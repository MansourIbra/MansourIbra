package gn.orange.cinema.Model;

import jakarta.persistence.*;
import org.hibernate.event.spi.PreInsertEvent;

import java.util.Collection;
import java.util.Date;

@Entity
public class Projection {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Film film;
    @OneToMany(mappedBy = "projection")
    private Collection<Ticket>tickets;
    @ManyToOne
    private Seance seance;
    public Projection(){}

    public Projection(Long id, Date dateProjection, Salle salle, Film film, Collection<Ticket> tickets, Seance seance,double prix) {
        Id = id;
        this.dateProjection = dateProjection;
        this.salle = salle;
        this.film = film;
        this.tickets = tickets;
        this.seance = seance;
        this.prix = prix;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateProjection() {
        return dateProjection;
    }

    public void setDateProjection(Date dateProjection) {
        this.dateProjection = dateProjection;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
