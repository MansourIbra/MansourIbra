package gn.orange.cinema.dto.request;

import java.util.ArrayList;
import java.util.List;

public class TicketFrom {
    private String nomClient;
    private List<Long> tickets= new ArrayList<>();

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }
}
