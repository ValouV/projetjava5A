package fr.epf.demoseptembre.persistence;

import fr.epf.demoseptembre.models.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author Valentin Vassas & Victor Aguer 19/09/2018
 */
@Repository
public interface CategorieDao extends CrudRepository<Categorie, Integer> {
  
}
