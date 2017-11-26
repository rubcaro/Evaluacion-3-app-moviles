package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;

public class AddClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
    }

    public void addClient (View view) {
        Toast msg;
        EditText clientRutText = (EditText) findViewById(R.id.clientRut);
        String clientRut = clientRutText.getText().toString();

        EditText clientLocalNameText = (EditText) findViewById(R.id.clientLocalName);
        String clientLocalName = clientLocalNameText.getText().toString();

        EditText clientContactNameText = (EditText) findViewById(R.id.clientContactName);
        String clientContactName = clientLocalNameText.getText().toString();

        EditText clientAddressText = (EditText) findViewById(R.id.clientAddress);
        String clientAddress = clientAddressText.getText().toString();

        EditText clientPhoneText = (EditText) findViewById(R.id.clientPhone);
        String clientPhone = clientPhoneText.getText().toString();

        if (clientRut.compareTo("")!=0 && clientLocalName.compareTo("")!=0 && clientContactName.compareTo("")!=0
                && clientAddress.compareTo("")!=0 && clientPhone.compareTo("")!=0) {

            ClientDatabaseHelper helper = new ClientDatabaseHelper(this);
            Client currentClient = new Client(clientRut, clientLocalName, clientContactName,clientAddress, clientPhone);
            helper.addClient(currentClient);
            msg = Toast.makeText(this, "Cliente correctamente ingresado", Toast.LENGTH_LONG);

        } else {
            msg = Toast.makeText(this, "Complete todos los campos por favor", Toast.LENGTH_LONG);
        }

        msg.show();
    }

    public void back(View view) {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }
}
