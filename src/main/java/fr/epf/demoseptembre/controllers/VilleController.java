package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.models.Ville;
import fr.epf.demoseptembre.persistence.VilleDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Controller
public class VilleController {

    private final VilleDao villeDao;

    public VilleController(VilleDao villeDao) {
        this.villeDao = villeDao;
    }

    /**
     * Ceci sera mappé sur l'URL '/users'.
     * C'est le routeur de Spring MVC qui va détecter et appeler directement cette méthode.
     * Il lui fournira un "modèle", auquel on pourra rajouter des attributs.
     * Ce modèle sera ensuite forwardé à une page web (dans resources/templates).
     * Le nom de la template est retourné par la fonction. Ici, elle appelle donc le template "users".
     *
     * @param model le modèle
     * @return
     */
    @GetMapping("/villes")
    public String getVilles(Model model) {
        model.addAttribute("data", villeDao.findAll());
        return "villes-list";
    }

}
