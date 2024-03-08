package gn.orange.cinema.service;

import gn.orange.cinema.Model.*;
import gn.orange.cinema.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService{
    
    private final VilleRepository villeRepository;
    
    private final CinemaRepository cinemaRepository;
    
    private final SalleRepository salleRepository;
    
    private final PlaceRepository placeRepository;
    
    private final SeanceRepository seanceRepository;
    
    private final FilmRepository filmRepository;
    
    private final ProjectionRepository projectionRepository;
    
    private final CategorieRepository categorieRepository;
    private final TicketRepository ticketRepository;
    
    public CinemaInitServiceImpl(
            VilleRepository villeRepository,
            CinemaRepository cinemaRepository,
            SalleRepository salleRepository,
            PlaceRepository placeRepository,
            SeanceRepository seanceRepository,
            FilmRepository filmRepository,
            ProjectionRepository projectionRepository,
            CategorieRepository categorieRepository,
            TicketRepository ticketRepository
            ){
        this.ticketRepository=ticketRepository;
        this.cinemaRepository=cinemaRepository;
        this.salleRepository=salleRepository;
        this.placeRepository=placeRepository;
        this.seanceRepository=seanceRepository;
        this.filmRepository=filmRepository;
        this.projectionRepository=projectionRepository;
        this.categorieRepository=categorieRepository;
        this.villeRepository=villeRepository;
        
    }

    @Override
    public void initVilles() {
        Stream.of("Conakry","Labe","Kankan","Mamou").forEach(nomVille->{
            Ville ville=new Ville();
            ville.setNom(nomVille);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initCinemas() {
    villeRepository.findAll().forEach(v->{
        Stream.of("CanalOlympiaKaloum","CanalOlympiaTombolia","CentreEmetteur").
                forEach(nomCinema->{
                    Cinema cinema =new Cinema();
                    cinema.setNom(nomCinema);
                    cinema.setNombreSalles(3+(int)(Math.random()*7));
                    cinema.setVille(v);
                    cinemaRepository.save(cinema);
                });
    });
    }

    @Override
    public void initSalles() {
    cinemaRepository.findAll().forEach(cinema ->{
        for (int i=0;i<cinema.getNombreSalles();i++){
            Salle salle=new Salle();
            salle.setNom("Salle"+(i+1));
            salle.setCinema(cinema);
            salle.setNombrePlace(15+(int)(Math.random()*20));
            salleRepository.save(salle);
        }
    });
    }

    @Override
    public void initPlaces() {
    salleRepository.findAll().forEach(salle -> {
        for (int i=0;i<salle.getNombrePlace();i++){
            Place place=new Place();
            place.setNumero(i+1);
            place.setSalle(salle);
            placeRepository.save(place);

        }
    });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s -> {
            Seance seance=new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Hirtoire","Actions","Fiction","Drame").forEach(cat->{
            Categorie categorie=new Categorie();
            categorie.setNom(cat);
            categorieRepository.save(categorie);
        });

    }

    @Override
    public void initFilms() {
        double[] durees=new double[] {1,1.5,2,2.5,3};
        List<Categorie> categories = categorieRepository.findAll();
        Stream.of("Game of Trones","Seigneur des Anneaux","Vikings","Spider Man","Bleed")
                .forEach(titreFilm->{
                    Film film=new Film();
                    film.setTitre(titreFilm);
                    film.setDuree(durees[new Random().nextInt(durees.length)]);
                    film.setPhoto(titreFilm.replaceAll(" ", "") + ".jpg");
                    film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                    filmRepository.save(film);
                });
    }

    @Override
    public void initProjections() {
               double[] prices=new double[] {30,50,60,70,90,100};
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepository.findAll().forEach(film -> {
                        seanceRepository.findAll().forEach(seance -> {
                            Projection projection=new Projection();
                            projection.setDateProjection(new Date());
                            projection.setFilm(film);
                            projection.setPrix(prices[new Random().nextInt(prices.length)]);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
              projectionRepository.findAll().forEach(p->{
            p.getSalle().getPlaces().forEach(place -> {
                Ticket ticket=new Ticket();
                ticket.setPlace(place);
                ticket.setPrix(p.getPrix());
                ticket.setProjection(p);
                ticket.setReservation(false);
                ticketRepository.save(ticket);
            });
        });

    }
}
