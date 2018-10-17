package fr.epf.demoseptembre.models

import javax.persistence.*

//un tips est un conseil sur une ville et via une catégorie

@Entity
data class Tips(@Id @GeneratedValue var id: Int? = null, @ManyToOne var ville: Ville? = null, @ManyToOne var categorie: Categorie? = null, var Titre: String? = null, var Auteur: String? = null, var Commentaire: String? = null, var NoteG: Float? = null, var noteTips: Int? = null) {
}