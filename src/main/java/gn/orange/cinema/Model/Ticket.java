package gn.orange.cinema.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String nomClient;
    private double prix;
    @Column(unique = true,nullable = true)
    private Integer codePayement;
    private boolean reservation;
    @ManyToOne
    private Place place;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Projection projection;
    public Ticket(){}

    public Ticket(Long id, String nomClient, double prix, int codePayement, boolean reservation, Place place, Projection projection) {
        this.id = id;
        this.nomClient = nomClient;
        this.prix = prix;
        this.codePayement = codePayement;
        this.reservation = reservation;
        this.place = place;
        this.projection = projection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCodePayement() {
        return codePayement;
    }

    public void setCodePayement(int codePayement) {
        this.codePayement = codePayement;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }
}
