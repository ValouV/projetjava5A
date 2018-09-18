package fr.epf.demoseptembre.models

import javax.persistence.*

@Entity
data class Tips(@Id @GeneratedValue var id: Int? = null, @ManyToOne var ville: Ville? = null, @ManyToOne var categorie: Categorie? = null, var Titre: String? = null, var Auteur: String? = null, var Commentaire: String? = null, var NoteG: Float? = null, var noteTips: Int? = null) {
}