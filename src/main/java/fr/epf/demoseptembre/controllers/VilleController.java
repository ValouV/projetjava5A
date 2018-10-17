package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.persistence.VilleDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Ce controleur permet la gestion de toutes les actions liées à la ville.
 *
 * @author Valentin Vassas & Victor Aguer 19/09/2018
 */

@Controller
public class VilleController {

    private final VilleDao villeDao;

    public VilleController(VilleDao villeDao) {
        this.villeDao = villeDao;
    }

    //récupération de la liste des villes
    @GetMapping("/")
    public String getVilles(Model model) {
        model.addAttribute("data", villeDao.findAll());
        return "villes-list";
    }

}
