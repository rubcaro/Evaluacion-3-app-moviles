package cl.inacap.parenas.evaluacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.ClientList;

public class AddClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
    }

    public void addClient (View view) {
        EditText client = (EditText) findViewById(R.id.clientName);
        String clientName = client.getText().toString();

       Client currentClient = new Client(clientName);
        currentClient.addClient();
    }
}
