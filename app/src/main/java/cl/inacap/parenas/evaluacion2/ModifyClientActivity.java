package cl.inacap.parenas.evaluacion2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;

public class ModifyClientActivity extends ListActivity {

    ClientDatabaseHelper helper = new ClientDatabaseHelper(this);
    List<Client> clients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_modify_client);
        //ListView clientList = (ListView)findViewById(R.id.list);
        ListView clientList = getListView();
        Client client = new Client();
        clients = helper.listClients();
        ArrayAdapter<Client> listaAdapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, clients);
        clientList.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {
        Intent intent = new Intent(ModifyClientActivity.this, EditClientActivity.class);
        String  rut = clients.get((int) id).getRut();
        intent.putExtra("client", rut);
        startActivity(intent);
    }

}
