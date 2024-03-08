package gn.orange.cinema.Repository;

import gn.orange.cinema.Model.Cinema;
import gn.orange.cinema.Model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {

}

