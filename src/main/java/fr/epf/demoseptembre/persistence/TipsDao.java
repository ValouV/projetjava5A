package fr.epf.demoseptembre.persistence;

import fr.epf.demoseptembre.models.Categorie;
import fr.epf.demoseptembre.models.Tips;
import fr.epf.demoseptembre.models.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La fonction crée par le developpeur permet de retrouver des tips via deux paramètres
 *
 * @author Valentin Vassas & Victor Aguer 19/09/2018
 */
@Repository
public interface TipsDao extends CrudRepository<Tips, Integer> {
    List<Tips> findByVilleAndCategorieOrderByNoteTipsDesc(Ville villeId, Categorie categorieId);
}
