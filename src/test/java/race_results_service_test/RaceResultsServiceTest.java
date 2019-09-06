package race_results_service_test;

import org.junit.Test;
import race_results_service.Client;
import race_results_service.Message;
import race_results_service.RaceResultsService;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    RaceResultsService raceResults = new RaceResultsService();
    Message message = mock(Message.class);
    Client clientA = mock(Client.class,"clientA");
    Client clientB = mock(Client.class, "clientB");
    //zero client
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }
    //one client
    @Test
    public void subscribedClientsShouldReceiveMessages(){
        Client client = mock(Client.class);
        raceResults.addSubscriber(client);
        raceResults.send(message);
        verify(client).receive(message);

    }
    //many clients
    @Test
    public void messageShouldBeSendToAllSubscribedClients(){
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);
        verify(clientA, never()).receive(message);
    }

}
