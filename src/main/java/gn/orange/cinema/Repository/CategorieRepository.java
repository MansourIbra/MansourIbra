package gn.orange.cinema.Repository;

import gn.orange.cinema.Model.Categorie;
import gn.orange.cinema.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
