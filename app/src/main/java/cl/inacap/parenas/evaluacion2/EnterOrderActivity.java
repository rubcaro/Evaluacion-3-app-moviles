package cl.inacap.parenas.evaluacion2;

import android.app.DatePickerDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.Order;
import cl.inacap.parenas.evaluacion2.modelo.Product;

public class EnterOrderActivity extends ListActivity {

    EditText date;
    DatePickerDialog datePickerDialog;
    int currentIdProduct;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_order);

        order = new Order();

        Client client = new Client();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Client> listaAdapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, client.getClients());
        spinner.setAdapter(listaAdapter);

        date = (EditText) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(EnterOrderActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        ListView clientList = getListView();
        ArrayAdapter<Product> listaAdapterProduct = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1,Product.products );
        clientList.setAdapter(listaAdapterProduct);

    }


    public void back(View view) {

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void addProduct(View view) {



        TextView productQuantityText = (TextView) findViewById(R.id.productQuantity);
        String productQuantity = productQuantityText.getText().toString();

        TextView selectedProductText = (TextView) findViewById(R.id.selectedProduct);
        String selectedProduct = selectedProductText.getText().toString();

        if(!selectedProduct.equals("") && !productQuantity.equals("")) {
            order.addProduct(currentIdProduct);
            TextView productsList = (TextView) findViewById(R.id.productsList);
            String value = productsList.getText().toString().concat("\n Producto: " + selectedProduct + " -  Cantidad: " + productQuantity);
            productsList.setText(value);

            productQuantityText.setText("");
            selectedProductText.setText("");

        } else {
            Toast msgError = Toast.makeText(this, "Seleccione un producto/cantidad primero", Toast.LENGTH_LONG);
            msgError.show();
        }

    }

    public void addOrder(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String client = spinner.getSelectedItem().toString();

        EditText dateText = (EditText) findViewById(R.id.date);
        String date = dateText.getText().toString();

        EditText valueText = (EditText) findViewById(R.id.value);
        String value = valueText.getText().toString();

        order.setClient(client);
        order.setDate(date);
        order.setValue(Integer.parseInt(value));
        order.save();

        Toast msgError = Toast.makeText(this, "Orden correctamente ingresada", Toast.LENGTH_LONG);
        msgError.show();
    }


    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {

        TextView selectedProduct = (TextView) findViewById(R.id.selectedProduct);
        Product currentProduct = Product.products.get((int) id);
        currentIdProduct = (int) id;
        selectedProduct.setText(currentProduct.getName());
    }
}
