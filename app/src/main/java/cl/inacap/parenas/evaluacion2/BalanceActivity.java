package cl.inacap.parenas.evaluacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import cl.inacap.parenas.evaluacion2.modelo.ClientDatabaseHelper;
import cl.inacap.parenas.evaluacion2.modelo.Order;

public class BalanceActivity extends AppCompatActivity {

    ClientDatabaseHelper helper = new ClientDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        int totalValue = 0;
        int toCollect = 0;
        int collected = 0;

        List<Order> deliveredOrders = helper.listOrders(Order.DELIVERED);
        List<Order> notDelivereedOrders = helper.listOrders(Order.NOT_DELIVERED);

        for (Order deliveredOrder : deliveredOrders) {
            collected = collected + deliveredOrder.getValue();
        }

        for (Order notDeliveredOrder : notDelivereedOrders) {
            toCollect = toCollect + notDeliveredOrder.getValue();
        }

        totalValue = toCollect + collected;

        TextView toCollectText = (TextView) findViewById(R.id.toCollectText);
        toCollectText.setText(String.valueOf(toCollect));

        TextView collectedText = (TextView) findViewById(R.id.collectedText);
        collectedText.setText(String.valueOf(collected));

        TextView totalValueText = (TextView) findViewById(R.id.totalValueText);
        totalValueText.setText(String.valueOf(totalValue));
    }
}
