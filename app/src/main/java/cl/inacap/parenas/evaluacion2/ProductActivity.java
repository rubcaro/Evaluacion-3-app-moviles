package cl.inacap.parenas.evaluacion2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import cl.inacap.parenas.evaluacion2.modelo.Product;


public class ProductActivity extends AppCompatActivity {

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        int productNumber = (Integer)getIntent().getExtras().get("product");
        //product = Product.products.get(productNumber);

        ImageView image = (ImageView) findViewById(R.id.foto);
        image.setImageResource(product.getImageId());
        image.setContentDescription(product.getDescription());

        TextView name = (TextView) findViewById(R.id.productNameText);
        name.setText(product.getName());

        TextView productDescription = (TextView) findViewById(R.id.productDescriptionText);
        productDescription.setText(product.getDescription());

    }

    public void addProduct(View view) {
        TextView quantityText = (TextView) findViewById(R.id.quantityText);
        int quantity = Integer.parseInt(quantityText.getText().toString());
        ArrayList<String> message = new ArrayList<>();
        message.add(product.getName());
        message.add(String.valueOf(quantity));

        Intent intent = new Intent(this, EnterOrderActivity.class);
        intent.putStringArrayListExtra("productOrder",message);
    }

    public void back(View view) {
        Intent intent = new Intent(this, EnterOrderActivity.class);
        startActivity(intent);
    }
}
