package cl.inacap.parenas.evaluacion2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 17-10-2017.
 */

public class ClientList {
    private List<Client> clients;
    private int quantity = 2;

    public ClientList() {
        clients = new ArrayList<>();
        clients.add(0, new Client("Carlos"));
        clients.add(1, new Client("Juan"));
    }

    public void addClient(Client client) {
        clients.add(quantity, client);
        quantity++;
    }
}
