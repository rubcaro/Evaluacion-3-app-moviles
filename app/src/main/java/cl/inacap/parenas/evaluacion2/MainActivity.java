package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;
import cl.inacap.parenas.evaluacion2.modelo.User;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View view) {
        EditText userText = (EditText) findViewById(R.id.userName);
        String userName = userText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.password);
        String password = passwordText.getText().toString();

        User user = new User();
        user.setName(userName);
        user.setPassword(password);

        if (user.checkLogin()) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else {
            TextView error = (TextView) findViewById(R.id.errorMessage);
            error.setText("Usuario y/o contraseña incorrecta");
        }

    }


}
