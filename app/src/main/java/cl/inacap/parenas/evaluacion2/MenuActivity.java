package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MenuActivity.this, ClientActivity.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(MenuActivity.this, EnterOrderActivity.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(MenuActivity.this, OrdersMenuActivity.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
