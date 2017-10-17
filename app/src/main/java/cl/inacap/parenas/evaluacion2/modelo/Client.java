package cl.inacap.parenas.evaluacion2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 17-10-2017.
 */

public class Client {
    private String name;
    private int state;

    public static final List<Client> clients = new ArrayList<Client>(){{
        add(new Client("Carlos"));
        add(new Client("Juan"));
    }};

    public Client(String name) {
        this.name = name;
        this.state = 1;
    }

    public Client(){

    }

    public void addClient() {
        clients.add(this);
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return name;
    }

}
