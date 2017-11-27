package cl.inacap.parenas.evaluacion2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.parenas.evaluacion2.modelo.Order;
import cl.inacap.parenas.evaluacion2.modelo.Product;

public class OrderDetailsActivity extends ListActivity {

    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

       /* int orderNumber = (Integer)getIntent().getExtras().get("order");
        order = Order.orders.get(orderNumber);

        TextView clientNameText = (TextView) findViewById(R.id.clientNameText);
        clientNameText.setText(order.getClient());

        TextView dateText = (TextView) findViewById(R.id.dateText);
        dateText.setText(order.getDate());

        TextView valueText = (TextView) findViewById(R.id.valueText);
        valueText.setText(String.valueOf(order.getValue()));

        TextView stateText =(TextView) findViewById(R.id.stateText);
        stateText.setText("Estado: " + order.getState());

        List<Product> products = new ArrayList<Product>();
        for (Integer id : order.getProducts()) {
            products.add(Product.products.get(id));
        }

        ListView clientList = getListView();
        ArrayAdapter<Product> listaAdapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1, products);
        clientList.setAdapter(listaAdapter);*/
    }

    public void back(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void deliver(View view) {
        //order.setState("Entregado");

        TextView stateText =(TextView) findViewById(R.id.stateText);
        stateText.setText("Estado: " + order.getState());

        Toast msgError = Toast.makeText(this, "Pedido correctamente entregado", Toast.LENGTH_LONG);
        msgError.show();
    }
}
