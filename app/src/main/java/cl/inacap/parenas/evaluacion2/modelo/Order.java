package cl.inacap.parenas.evaluacion2.modelo;

import java.util.List;

/**
 * Created by Rubén on 18-10-2017.
 */

public class Order {
    private String id; //String por que no quise cambiar todas las cosas :)
    private String date;
    private int value;
    private int state;
    private Client client;
    private List<ProductOrder> products;

    public static final int DELIVERED = 1;
    public static final int  NOT_DELIVERED = 0;

    public Order(String date, int value,int state) {
        this.date = date;
        this.value = value;
        this.state = state;
    }

    public Order() {
    }

    public String getState() {
        return this.state  == Order.DELIVERED ? "entregado" : "no entregado";
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "Fecha: " + this.date + '\n'+
                "Rut Cliente: " + this.client.getRut() + '\n' +
                "Total a pagar: " + this.getValue() + '\n' +
                "Estado: " + this.getState() + '\n';
    }
}
