package cl.inacap.parenas.evaluacion2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;
import cl.inacap.parenas.evaluacion2.modelo.Order;

public class DeliverOrderActivity extends ListActivity {

    ClientDatabaseHelper helper = new ClientDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_order);

        ListView clientList = getListView();
        List<Order> ordersNotDelivered = helper.listOrders(Order.NOT_DELIVERED);

        ArrayAdapter<Order> listaAdapter = new ArrayAdapter<Order>(this,
                android.R.layout.simple_list_item_1, ordersNotDelivered);
        clientList.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {
        Intent intent = new Intent(DeliverOrderActivity.this, OrderDetailsActivity.class);
        intent.putExtra("order", (int)id);
        startActivity(intent);
    }
}
