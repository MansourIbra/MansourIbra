package gn.orange.cinema.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Salle {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 70)
    private String nom;
    private int nombrePlace;
    @ManyToOne
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Cinema cinema;
    @OneToMany(mappedBy ="salle")
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;
    @OneToMany(mappedBy = "salle")
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection>projections;
    public Salle(){}

    public Salle(Long id, String nom, int nombrePlace, Cinema cinema, Collection<Place> places, Collection<Projection> projections) {
        Id = id;
        this.nom = nom;
        this.nombrePlace = nombrePlace;
        this.cinema = cinema;
        this.places = places;
        this.projections = projections;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Collection<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Place> places) {
        this.places = places;
    }

    public Collection<Projection> getProjections() {
        return projections;
    }

    public void setProjections(Collection<Projection> projections) {
        this.projections = projections;
    }
}
