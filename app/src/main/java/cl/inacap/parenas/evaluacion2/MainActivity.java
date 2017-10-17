package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText userText = (EditText) findViewById(R.id.userName);
        String user = userText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.password);
        String password = passwordText.getText().toString();

        if ("user".equals(user) && "secret".equals(password)) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else {
            TextView error = (TextView) findViewById(R.id.errorMessage);
            error.setText("Usuario y/o contraseña incorrecta");
        }

    }


}
