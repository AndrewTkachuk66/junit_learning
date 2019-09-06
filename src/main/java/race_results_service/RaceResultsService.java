package race_results_service;

import java.util.ArrayList;
import java.util.Collection;

public class RaceResultsService {

    private Collection<Client> clients = new ArrayList<>();
    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
        for(Client client: clients){
            client.receive(message);
        }
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}
