package cl.inacap.parenas.evaluacion2.modelo;

/**
 * Created by Rubén on 17-10-2017.
 */


public class Client {
    private String rut;
    private String localName;
    private String contactName;
    private String address;
    private String phone;
    private String id;
    private int state;

    public static final int ACTIVE_CLIENT = 1;
    public static final int INACTIVE_CLIENT = 0;

    public Client(String rut, String localname, String contactName, String address, String phone) {
        this.rut = rut;
        this.localName = localname;
        this.contactName = contactName;
        this.address = address;
        this.phone = phone;
        this.state = 1;
    }


    public Client(){

    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" +
                "Rut: " + rut + '\'' +
                "Nombre del local: " + localName + '\'' +
                "Nombre de contacto: " + contactName + '\'' +
                "Dirección: " + address + '\'' +
                "Telefono: " + phone + '\'' +
                "]";
    }

}
