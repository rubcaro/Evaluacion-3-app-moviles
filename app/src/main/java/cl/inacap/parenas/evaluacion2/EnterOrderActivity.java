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

import java.util.Calendar;

import cl.inacap.parenas.evaluacion2.modelo.Client;
import cl.inacap.parenas.evaluacion2.modelo.Product;

public class EnterOrderActivity extends ListActivity {

    EditText date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_order);

        Client client = new Client();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Client> listaAdapter = new ArrayAdapter<Client>(this,
                android.R.layout.simple_list_item_1, client.getClients());
        spinner.setAdapter(listaAdapter);

        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(EnterOrderActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        ListView clientList = getListView();
        //Product product = new Product();
        ArrayAdapter<Product> listaAdapterProduct = new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1,Product.products );
        clientList.setAdapter(listaAdapterProduct);

    }


    public void back(View view) {

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void addOrder(View view) {

    }


    @Override
    public void onListItemClick(ListView ListView, View item, int posicion, long id) {
        Intent intent = new Intent(EnterOrderActivity.this, EditClientActivity.class);
        intent.putExtra("client", (int)id);
        startActivity(intent);
    }
}
