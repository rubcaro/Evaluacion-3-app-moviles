package cl.inacap.parenas.evaluacion2.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.parenas.evaluacion2.R;

/**
 * Created by Rubén on 24-11-2017.
 */

public class ClientDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "bd_orders";
    private static final int DB_VERSION = 1;

    public ClientDatabaseHelper(Context context) {

        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlClient = "CREATE TABLE CLIENTS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "RUT TEXT, LOCAL_NAME TEXT, CONTACT_NAME TEXT, ADDRESS TEXT, PHONE TEXT, STATE INT);";
        String sqlProduct = "CREATE TABLE PRODUCTS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, DESCRIPTION TEXT, IMAGE_ID INT);";
        String sqlOrder = "CREATE TABLE ORDERS(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DATE TEXT, VALUE INT, STATE INT, CLIENT_RUT TEXT);";
        String sqlProductOrder = "CREATE TABLE PRODUCT_ORDER( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PRODUCT_ID INT, CLIENT_ID INT, QUANTITY INT, VALUE INT);";
        sqLiteDatabase.execSQL(sqlClient);
        sqLiteDatabase.execSQL(sqlProduct);
        sqLiteDatabase.execSQL(sqlOrder);
        sqLiteDatabase.execSQL(sqlProductOrder);
        loadProducts();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST CLIENTS");
        onCreate(sqLiteDatabase);
    }

    public void loadProducts() {
        addProduct((new Product("Tomate", R.drawable.tomate, "Descripción del tomate")));
        addProduct(new Product("Palta", R.drawable.palta,  "Descripción de la palta"));
        addProduct(new Product("Queso", R.drawable.queso,  "Descripción del queso"));
        addProduct(new Product("Manzana", R.drawable.manzana,  "Descripción de la manzana"));
        addProduct(new Product("Pera", R.drawable.pera, "Descripción de la pera"));
    }

    public void addClient(Client client) {
        ContentValues values = new ContentValues();
        values.put("RUT", client.getRut());
        values.put("LOCAL_NAME", client.getLocalName());
        values.put("CONTACT_NAME", client.getContactName());
        values.put("ADDRESS", client.getAddress());
        values.put("PHONE", client.getPhone());
        values.put("STATE", Client.ACTIVE_CLIENT);
        getWritableDatabase().insert("CLIENTS", null, values);
    }

    public String deleteClient(String rut) {
        String msg = "Cliente eliminado correctamente";

        String sqlTxt = "UPDATE CLIENTS SET STATE = " + Client.INACTIVE_CLIENT + " WHERE RUT = ?";
        Object[] arguments = new Object[]{rut};

        try {
            getWritableDatabase().execSQL(sqlTxt, arguments);
        } catch(SQLException e) {
            msg = "Error al eliminar el cliente";
            return msg;
        }

        return msg;
    }

    public String modifyClient(Client client) {
        String msg = "Cliente correctamente modificado";
        String sqlText = "UPDATE CLIENTS SET RUT = ?, LOCAL_NAME  = ?, CONTACT_NAME = ?," +
                            "ADDRESS = ?, PHONE = ?  WHERE _id = ?";
        Object[] arguments = new Object[]{client.getRut(), client.getLocalName(), client.getContactName(),
                                        client.getAddress(), client.getPhone(), client.getId()};

        try {
            getWritableDatabase().execSQL(sqlText, arguments);
        } catch(SQLException e) {
            msg = "Error al actualizar el cliente";
            return msg;
        }
        return msg;
    }

    public Client searchClient(String rutToSearch) {
        Client client = null;
        String sqlText = "SELECT _id, RUT, LOCAL_NAME, CONTACT_NAME, ADDRESS, PHONE FROM CLIENTS WHERE RUT = ?";

        Cursor cursor = getReadableDatabase().rawQuery(sqlText, new String[] {rutToSearch});
        cursor.moveToFirst();
        String id = cursor.getString(0);
        String rut = cursor.getString(1);
        String localName = cursor.getString(2);
        String contactName = cursor.getString(3);
        String address = cursor.getString(4);
        String phone = cursor.getString(5);
        client = new Client(rut, localName, contactName, address, phone);
        client.setId(id);

        return client;
    }

    public List<Client> listClients() {
        List<Client> clients = new ArrayList<>();
        String sqlText = "SELECT _id, RUT, LOCAL_NAME, CONTACT_NAME, ADDRESS, PHONE FROM CLIENTS";

        try {
            Cursor cursor = getReadableDatabase().rawQuery(sqlText, null);
            cursor.moveToFirst();
            Client client;
            do {
                client = new Client(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                                    cursor.getString(5));
                client.setId(cursor.getString(0));
                clients.add(client);
            } while (cursor.moveToNext());
        } catch(SQLException e) {
            clients = null;
        }

        return clients;
    }

    public void addProduct(Product product) {
        ContentValues values = new ContentValues();
        values.put("NOMBRE", product.getName());
        values.put("DESCRIPTION", product.getDescription());
        values.put("IMAGE_ID", product.getImageId());
        getWritableDatabase().insert("PRODUCTS", null, values);
    }

    public void addOrder(Order order) {
        ContentValues values = new ContentValues();
        values.put("DATE", order.getDate());
        values.put("VALUE", order.getValue());
        values.put("STATE", Order.NOT_DELIVERED);
        values.put("CLIENT_RUT", order.getClient().getRut());
        getWritableDatabase().insert("ORDERS", null, values);
    }

    public String deliverOrder(int id) {
        String message = "Orden ha cambiado su estado a entregada";

        String sqlText = "UPDATE ORDERS SET STATE = " + Order.DELIVERED + " WHERE _id = ?";
        Object[] arguments = new Object[]{id};

        try {
            getWritableDatabase().execSQL(sqlText, arguments);
        } catch (SQLException e) {
            message = "El estado de la orden no se ha podido cambiar, lo sentimos";
            return message;
        }

        return message;
    }

    public List<Order> listOrders() {
        List <Order> orders = new ArrayList<>();
        String sqlText = "SELECT _id, DATE, VALUE, STATE, CLIENT_RUT FROM ORDERS";

        try {
            Cursor cursor = getWritableDatabase().rawQuery(sqlText, null);
            cursor.moveToFirst();
            Order order;
            String rut;
            do {
                String date = cursor.getString(1);
                String id = cursor.getString(0);
                int value = Integer.parseInt(cursor.getString(2));
                int state = Integer.parseInt(cursor.getString(3));
                order = new Order(date, value, state);

                rut = cursor.getString(4);
                order.setClient(searchClient(rut));
                order.setProducts(searchProductOrder(id));

                order.setId(cursor.getString(0));
                orders.add(order);
            } while (cursor.moveToNext());
        } catch (SQLException e) {
            orders = null;
        }
        return orders;
    }

    public List<ProductOrder> searchProductOrder(String id) {
        List <ProductOrder> list = new ArrayList<>();
        String sqlText = "SELECT PRODUCT_ID, ORDER_ID, QUANTITY, VALUE FROM PRODUCT_ORDER";

        try {
            Cursor cursor = getWritableDatabase().rawQuery(sqlText, null);
            cursor.moveToFirst();
            ProductOrder productOrder;

            do {
                int product_id = Integer.parseInt(cursor.getString(0));
                int order_id = Integer.parseInt(cursor.getString(1));
                int quantity = Integer.parseInt(cursor.getString(2));
                int value = Integer.parseInt(cursor.getString(3));
                productOrder = new ProductOrder(quantity, value, product_id, order_id);
                list.add(productOrder);
            } while (cursor.moveToNext());
        } catch (SQLException e) {
            list = null;
        }

        return list;
    }

}