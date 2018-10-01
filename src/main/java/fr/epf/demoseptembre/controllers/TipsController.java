package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.models.Categorie;
import fr.epf.demoseptembre.models.Tips;
import fr.epf.demoseptembre.models.Ville;
import fr.epf.demoseptembre.persistence.TipsDao;
import fr.epf.demoseptembre.persistence.VilleDao;
import fr.epf.demoseptembre.persistence.CategorieDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Controller
public class TipsController {

    private final TipsDao tipsDao;
    private final VilleDao villeDao;
    private final CategorieDao categorieDao;

    public TipsController(TipsDao tipsDao, VilleDao villeDao, CategorieDao categorieDao) {
        this.tipsDao = tipsDao;
        this.villeDao = villeDao;
        this.categorieDao = categorieDao;
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

    @GetMapping("/cityTips/{villeid}")
    public String getTipsByVille(@PathVariable int villeid, Model model, Tips tips, Ville ville, Categorie categorie) {
        final int categorieid = 8;
        ville = villeDao.findById(villeid).get();
        categorie = categorieDao.findById(categorieid).get();
        tips.setVille(ville);
        tips.setCategorie(categorie);
        model.addAttribute("tiphtml", tips);
        model.addAttribute("dataCategorie", categorieDao.findAll());
        model.addAttribute("data", tipsDao.findByVilleAndCategorieOrderByNoteTipsDesc(ville, categorie));
        return "tips-list";
    }

    @GetMapping("/noteGlobale/{villeid}")
    public String getNoteGlobale(@PathVariable int villeid, Model model, Tips tips, Ville ville, Categorie categorie, float note) {
        final int categorieid = 8;
        ville = villeDao.findById(villeid).get();
        categorie = categorieDao.findById(categorieid).get();
        tips.setVille(ville);
        tips.setCategorie(categorie);
        return "note";
    }

    @GetMapping("/cityTips/{villeid}/{categorieid}")
    public String getTipsByVilleAndCategorie(@PathVariable int villeid, @PathVariable int categorieid, Model model, Tips tips, Ville ville, Categorie categorie) {
        ville = villeDao.findById(villeid).get();
        categorie = categorieDao.findById(categorieid).get();
        tips.setVille(ville);
        tips.setCategorie(categorie);
        model.addAttribute("tiphtml", tips);
        model.addAttribute("dataCategorie", categorieDao.findAll());
        model.addAttribute("data", tipsDao.findByVilleAndCategorieOrderByNoteTipsDesc(ville, categorie));
        return "tips-list";
    }


    @PostMapping("/addtips/{idville}/{idcategorie}")
    public String addTipsWithURLParameters(@PathVariable int idville, @PathVariable int idcategorie, Tips tips, Model model) {
        tips.setNoteTips(0);
        tips.setVille(villeDao.findById(idville).get());
        tips.setCategorie(categorieDao.findById(idcategorie).get());
        tipsDao.save(tips);
        return "redirect:/cityTips/{idville}/{idcategorie}";
    }

    @GetMapping("/plusOne/{id}")
    public String upgradeTips(@PathVariable int id, Model model, Tips tips) {
        tips = tipsDao.findById(id).get();
        final int note = tips.getNoteTips()+1;
        tips.setNoteTips(note);
        tipsDao.save(tips);
        return "redirect:/cityTips/" + tips.getVille().getId() + "/" + tips.getCategorie().getId();
    }

    @GetMapping("/minusOne/{id}")
    public String downgradeTips(@PathVariable int id, Model model, Tips tips) {
        tips = tipsDao.findById(id).get();
        final int note = tips.getNoteTips()-1;
        tips.setNoteTips(note);
        tipsDao.save(tips);
        return "redirect:/cityTips/" + tips.getVille().getId() + "/" + tips.getCategorie().getId();
    }

    @GetMapping("/noteGeneraleVille/{id}")
    public String noteVille(@PathVariable int id, Model model) {
        List<Tips> tips = tipsDao.findByVilleAndCategorieOrderByNoteTipsDesc(villeDao.findById(id).get(),categorieDao.findById(8).get());
        if (tips.isEmpty()){
            model.addAttribute("note", 0);
            return "nombre";
        }
        float note = 0;
        int i = 0;
        for (Tips tip:tips
             ) {
            note = tip.getNoteG() + note;
            i++;
        }
        note = note / i;
        System.out.println(note);
        model.addAttribute("note", note);
        return "nombre";
    }

}
