package gn.orange.cinema.Repository;

import gn.orange.cinema.Model.Place;
import gn.orange.cinema.Model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
