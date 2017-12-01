package cl.inacap.parenas.evaluacion2.modelo;

/**
 * Created by Rubén on 25-11-2017.
 */

public class ProductOrder {
    private int product_id;
    private int order_id;
    private int quantity;
    private int value;

    public ProductOrder(int quantity, int value, int product) {
        this.product_id = product;
        this.quantity = quantity;
        this.value = value;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
