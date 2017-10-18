package cl.inacap.parenas.evaluacion2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 18-10-2017.
 */

public class Order {
    public int id;
    public int value;
    public List<Integer> products;

    public static final List<Order> orders = new ArrayList<Order>() {{

    }};

    public Order() {
        this.products = new ArrayList<Integer>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
