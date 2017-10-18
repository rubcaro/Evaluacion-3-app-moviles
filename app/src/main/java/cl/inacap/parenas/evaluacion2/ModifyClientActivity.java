package cl.inacap.parenas.evaluacion2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.inacap.parenas.evaluacion2.modelo.Client;

public class ModifyClientActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_modify_client);
        //ListView clientList = (ListView)findViewById(R.id.list);
        ListView clientList = getListView();
        Client client = new Client();
        ArrayAdapter<Client> listaAdapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, client.getClients());
        clientList.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {
        Intent intent = new Intent(ModifyClientActivity.this, EditClientActivity.class);
        intent.putExtra("client", (int)id);
        startActivity(intent);
    }

}
