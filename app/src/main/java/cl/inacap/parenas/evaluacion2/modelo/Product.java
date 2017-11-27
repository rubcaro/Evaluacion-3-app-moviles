package cl.inacap.parenas.evaluacion2.modelo;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.parenas.evaluacion2.R;

/**
 * Created by Rubén on 18-10-2017.
 */

public class Product {
    private String name;
    private String description;
    private int imageId;
    private int value;
    private int id;

   /* public static final List<Product> products = new ArrayList<Product>() {{
        add(new Product("Tomate", R.drawable.tomate, "Descripción del tomate"));
        add(new Product("Palta", R.drawable.palta,  "Descripción de la palta"));
        add(new Product("Queso", R.drawable.queso,  "Descripción del queso"));
        add(new Product("Manzana", R.drawable.manzana,  "Descripción de la manzana"));
        add(new Product("Pera", R.drawable.pera, "Descripción de la pera"));
    }} ;*/

    public Product(String name, int imageId, String description, int value) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.value = value;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return name + " $" + value;
    }
}
