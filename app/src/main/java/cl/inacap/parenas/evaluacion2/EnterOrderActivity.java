package cl.inacap.parenas.evaluacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cl.inacap.parenas.evaluacion2.modelo.Client;

public class EnterOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_order);

        Client client = new Client();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Client> listaAdapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, client.getClients());
        spinner.setAdapter(listaAdapter);
    }
}
