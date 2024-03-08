package gn.orange.cinema.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Seance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date heureDebut;

    public Seance() {
    }

    public Seance(Long id, Date heureDebut) {
        this.id = id;
        this.heureDebut = heureDebut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }
}
