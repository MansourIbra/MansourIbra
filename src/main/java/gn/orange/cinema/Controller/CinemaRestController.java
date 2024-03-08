package gn.orange.cinema.Controller;

import gn.orange.cinema.Model.Film;
import gn.orange.cinema.Model.Ticket;
import gn.orange.cinema.Repository.FilmRepository;
import gn.orange.cinema.Repository.TicketRepository;
import gn.orange.cinema.dto.request.TicketFrom;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name = "id") Long id) throws Exception {
        Film f = filmRepository.findById(id).get();
        String photoName = f.getPhoto();
        Path path = Paths.get(System.getProperty("user.home") + "/cinema/images/" + photoName);
        return Files.readAllBytes(path);

    }

    //Paiement des tickets
    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketFrom ticketFrom) {
        List<Ticket> listTickets = new ArrayList<>();
        ticketFrom.getTickets().forEach(idTicket->{
           Ticket ticket=ticketRepository.findById(idTicket).get();
           ticket.setNomClient(ticketFrom.getNomClient());
           ticket.setReservation(true);
           ticketRepository.save(ticket);
           listTickets.add(ticket);
        });
        return listTickets;
    }

}

