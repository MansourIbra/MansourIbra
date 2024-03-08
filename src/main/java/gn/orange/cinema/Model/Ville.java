package gn.orange.cinema.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length =70)
    private  String nom;
    private double longitude,latitude,altitude;
    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;
    public Ville() {}

    public Ville(Long id, String nom, double longitude, double latitude, double altitude, Collection<Cinema> cinemas) {
        Id = id;
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.cinemas = cinemas;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public Collection<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Collection<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
