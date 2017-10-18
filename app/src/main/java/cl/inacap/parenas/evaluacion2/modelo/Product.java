package cl.inacap.parenas.evaluacion2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 18-10-2017.
 */

public class Product {
    private String name;
    private int quantity;
    private int product_id;
    public static int id = 0;

    public static final List<Product> products = new ArrayList<Product>() {{
        add(new Product("Tomate", 50));
        add(new Product("Palta", 30));
        add(new Product("Queso", 10));
        add(new Product("Manzana", 60));
        add(new Product("Pera", 30));
    }} ;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.id++;
        this.product_id = this.id;
    }

    public Product() {
    }

    public static List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return name;
    }
}
