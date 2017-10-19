package cl.inacap.parenas.evaluacion2.modelo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 18-10-2017.
 */

public class Order {
    public int value;
    public String date;
    public String client;
    public List<Integer> products;

    public static final List<Order> orders = new ArrayList<Order>() {{

    }};

    public Order() {
        this.products = new ArrayList<Integer>();
    }

    public void addProduct(int id) {
        this.products.add(id);
    }

    public void save() {
        orders.add(this);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {

        return client + " " + date + " " + value + " " + products.get(0);
    }
}
