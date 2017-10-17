package cl.inacap.parenas.evaluacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.inacap.parenas.evaluacion2.modelo.Client;

public class ModifyClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_client);
        ListView clientList = (ListView)findViewById(R.id.clientList);
        Client client = new Client();
        ArrayAdapter<Client> listaAdapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, client.clients);
        clientList.setAdapter(listaAdapter);
    }

}
