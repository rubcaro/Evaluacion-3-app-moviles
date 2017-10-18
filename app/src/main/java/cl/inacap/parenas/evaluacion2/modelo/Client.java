package cl.inacap.parenas.evaluacion2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 17-10-2017.
 */

public class Client {
    private String name;
    private int state;
    private int clientId;
    public static int id = 0;

    public static final List<Client> clients = new ArrayList<Client>(){{
        add(new Client("Carlos"));
        add(new Client("Juan"));
    }};

    public Client(String name) {
        this.name = name;
        this.state = 1;
        this.id++;
        this.clientId = this.id;
    }


    public Client(){

    }

    public void addClient() {
        clients.add(this);
    }

    public void deleteClient(int id) {
        clients.get(id).setState(0);
    }

    public void edit() {
        clients.set(this.getClientId()-1, this);
    }

    public List<Client> getClients() {
        List<Client> availableClients = new ArrayList<>();
        for(Client c : clients) {
            if(c.getState() == 1) {
                availableClients.add(c);
            }
        }
        return availableClients;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return name + this.getClientId();
    }

}
