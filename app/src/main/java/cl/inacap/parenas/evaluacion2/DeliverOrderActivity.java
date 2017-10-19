package cl.inacap.parenas.evaluacion2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.Order;

public class DeliverOrderActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_order);

        ListView clientList = getListView();
        Order order = new Order();
        ArrayAdapter<Order> listaAdapter = new ArrayAdapter<Order>(this,
                android.R.layout.simple_list_item_1, Order.orders);
        clientList.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {
        Intent intent = new Intent(DeliverOrderActivity.this, EditClientActivity.class);
        intent.putExtra("order", (int)id);
        startActivity(intent);
    }
}
