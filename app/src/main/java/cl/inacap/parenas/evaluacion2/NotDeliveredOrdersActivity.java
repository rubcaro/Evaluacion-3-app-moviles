package cl.inacap.parenas.evaluacion2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;
import cl.inacap.parenas.evaluacion2.modelo.Order;

public class NotDeliveredOrdersActivity extends ListActivity {

    ClientDatabaseHelper helper = new ClientDatabaseHelper(this);
    List<Order> deliveredOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_delivered_orders);

        ListView clientList = getListView();
        deliveredOrders = helper.listOrders(Order.DELIVERED);

        ArrayAdapter<Order> listaAdapter = new ArrayAdapter<Order>(this,
                android.R.layout.simple_list_item_1, deliveredOrders);
        clientList.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {
        Intent intent = new Intent(NotDeliveredOrdersActivity.this, OrderDetailsActivity.class);
        String orderId = deliveredOrders.get((int) id).getId();
        intent.putExtra("order", orderId);
        startActivity(intent);
    }
}
