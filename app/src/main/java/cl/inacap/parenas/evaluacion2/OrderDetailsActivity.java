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

import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;
import cl.inacap.parenas.evaluacion2.modelo.Order;
import cl.inacap.parenas.evaluacion2.modelo.Product;
import cl.inacap.parenas.evaluacion2.modelo.ProductOrder;

public class OrderDetailsActivity extends ListActivity {

    Order order;
    ClientDatabaseHelper helper = new ClientDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        String orderNumber = getIntent().getExtras().get("order").toString();
        order = helper.searchOrder(orderNumber);
        List<String> productsDetails = new ArrayList<>();

        for (ProductOrder product : order.getProducts()) {

            Product p = helper.searchProduct(product.getProduct_id());
            String chain = "Producto: " +  p.getName() + " - Cantidad: " + product.getQuantity() + " - Valor: " + product.getValue();
            productsDetails.add(chain);
        }


        TextView clientNameText = (TextView) findViewById(R.id.clientNameText);
        clientNameText.setText(order.getClient().getLocalName());

        TextView dateText = (TextView) findViewById(R.id.dateText);
        dateText.setText(order.getDate());

        TextView valueText = (TextView) findViewById(R.id.valueText);
        valueText.setText(String.valueOf(order.getValue()));

        TextView stateText =(TextView) findViewById(R.id.stateText);
        stateText.setText("Estado: " + order.getState());


        ListView clientList = getListView();
        ArrayAdapter<String> listaAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, productsDetails);
        clientList.setAdapter(listaAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void deliver(View view) {
        String message = helper.deliverOrder(order.getId());

        TextView stateText =(TextView) findViewById(R.id.stateText);
        stateText.setText("Estado: " + order.getState());

        Toast msgError = Toast.makeText(this, message, Toast.LENGTH_LONG);
        msgError.show();

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
