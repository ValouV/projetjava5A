package fr.epf.demoseptembre;

import fr.epf.demoseptembre.models.Tips;
import fr.epf.demoseptembre.models.Ville;
import fr.epf.demoseptembre.models.Categorie;
import fr.epf.demoseptembre.persistence.TipsDao;
import fr.epf.demoseptembre.persistence.VilleDao;
import fr.epf.demoseptembre.persistence.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class DemoSeptembreApplication {
  
  @Autowired
  private VilleDao villeDao;
  @Autowired
  private TipsDao tipsDao;
  @Autowired
  private CategorieDao categorieDao;



    public static void main(String[] args) {
    // Point d'entrée de l'application.
    // On dit à Spring de s'initialiser
    // Il va aller "regarder" nos classes et détecter les annotations des singletons 
    // (@Controller, @Repository, @Component, @Service, etc...)
    // Ensuite, il va construire l'arbre de dépendances et le résoudre en injectant les données dans les bonnes classes
    SpringApplication.run(DemoSeptembreApplication.class);
  }

  /**
   * On appelle cette méthode lorsque Spring a terminé son initialisation.
   * Ici, on va réinitialiser la DB et insérer 3 entrées.
   */
  @PostConstruct
  public void init() {
    villeDao.deleteAll();
    categorieDao.deleteAll();
    tipsDao.deleteAll();
    villeDao.save(new Ville(1,"Paris", "France"));
    villeDao.save(new Ville(2, "Barcelone", "Espagne"));
    villeDao.save(new Ville(3, "Londres", "UK"));
    villeDao.save(new Ville(4, "Berlin", "UK"));
    villeDao.save(new Ville(5, "Bruxelles", "UK"));
    villeDao.save(new Ville(6, "Amsterdam", "UK"));
    villeDao.save(new Ville(7, "Prague", "UK"));
    categorieDao.save(new Categorie(8, "Général"));
    categorieDao.save(new Categorie(9, "Restaurant"));
    categorieDao.save(new Categorie(10, "Hotel"));
    categorieDao.save(new Categorie(11, "Boite de Nuit"));
    categorieDao.save(new Categorie(12, "Musée"));
    categorieDao.save(new Categorie(13, "Parc"));
    tipsDao.save(new Tips(14, villeDao.findById(1).get(), categorieDao.findById(9).get(), "trop bien", "marc", "ce resto est génial de fou", (float) 4.2, 0));
    tipsDao.save(new Tips(15, villeDao.findById(1).get(), categorieDao.findById(9).get(), "excellent", "marc", "je me suis trompé il est encore mieux que ça", (float) 4.8, 0));
    tipsDao.save(new Tips(16, villeDao.findById(1).get(), categorieDao.findById(8).get(), "nul", "marc", "Paris c'est pas Marseille, allez l'OM", (float) 2.8, 0));

  }
}