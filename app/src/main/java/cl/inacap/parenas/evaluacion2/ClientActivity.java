package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(ClientActivity.this, AddClientActivity.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(ClientActivity.this, ModifyClientActivity.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(ClientActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
