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
import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;

public class EditClientActivity extends AppCompatActivity {

    Client client;
    ClientDatabaseHelper helper = new ClientDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);
        String  rut = getIntent().getExtras().get("client").toString();
        client = helper.searchClient(rut);

        TextView title = (TextView) findViewById(R.id.clientTitle);
        title.setText("Modificar datos de " + client.getLocalName());

        EditText clientRut = (EditText) findViewById(R.id.clientRut);
        clientRut.setText(client.getRut());

        EditText clientLocalName = (EditText) findViewById(R.id.clientLocalName);
        clientLocalName.setText(client.getLocalName());

        EditText clientContactName = (EditText) findViewById(R.id.clientContactName);
        clientContactName.setText(client.getContactName());

        EditText clientAddress = (EditText) findViewById(R.id.clientAddress);
        clientAddress.setText(client.getAddress());

        EditText clientPhone = (EditText) findViewById(R.id.clientPhone);
        clientPhone.setText(client.getPhone());

    }

    public void back(View view) {

        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    public void delete(View view) {
        String message = helper.deleteClient(client.getRut());
        Toast msgError = Toast.makeText(this, message, Toast.LENGTH_LONG);
        msgError.show();
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    public void edit(View view) {

        EditText clientRut = (EditText) findViewById(R.id.clientRut);
        String rut = clientRut.getText().toString();
        client.setRut(rut);

        EditText clientLocalName = (EditText) findViewById(R.id.clientLocalName);
        String localName = clientLocalName.getText().toString();
        client.setLocalName(localName);

        EditText clientContactName = (EditText) findViewById(R.id.clientContactName);
        String contactName = clientContactName.getText().toString();
        client.setContactName(contactName);

        EditText clientAddress = (EditText) findViewById(R.id.clientAddress);
        String address = clientAddress.getText().toString();
        client.setAddress(address);

        EditText clientPhone = (EditText) findViewById(R.id.clientPhone);
        String phone = clientPhone.getText().toString();
        client.setPhone(phone);

        String message = helper.modifyClient(client);
        Toast msgError = Toast.makeText(this, message, Toast.LENGTH_LONG);
        msgError.show();
    }

}

