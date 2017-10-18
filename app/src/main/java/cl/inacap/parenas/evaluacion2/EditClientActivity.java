package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.inacap.parenas.evaluacion2.modelo.Client;

public class EditClientActivity extends AppCompatActivity {

    Client c = new Client();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);
        int clientNumber = (Integer)getIntent().getExtras().get("client");
        List<Client> clients = c.getClients();

        TextView title = (TextView) findViewById(R.id.clientTitle);
        title.setText("Modificar datos de " + clients.get(clientNumber).getName());

        EditText name = (EditText) findViewById(R.id.clientName);
        name.setText(clients.get(clientNumber).getName());

    }

    public void back(View view) {

        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    public void delete(View view) {
        Log.d("mensaje",String.valueOf( c.getClients().get((Integer)getIntent().getExtras().get("client")).getClientId()-1));
        c.deleteClient((c.getClients().get((Integer)getIntent().getExtras().get("client")).getClientId()-1));
        Toast msgError = Toast.makeText(this, "Usuario correctamente eliminado", Toast.LENGTH_LONG);
        msgError.show();
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    public void edit(View view) {
        Log.d("mensaje",String.valueOf( c.getClients().get((Integer)getIntent().getExtras().get("client")).getClientId()-1));
        Client editedClient = c.clients.get(c.getClients().get((Integer)getIntent().getExtras().get("client")).getClientId()-1);
        EditText client = (EditText) findViewById(R.id.clientName);
        String clientName = client.getText().toString();
        editedClient.setName(clientName);
        editedClient.edit();
        Toast msgError = Toast.makeText(this, "Usuario correctamente editado", Toast.LENGTH_LONG);
        msgError.show();
    }

}

