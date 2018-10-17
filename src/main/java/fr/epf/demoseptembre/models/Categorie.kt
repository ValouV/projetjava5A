package fr.epf.demoseptembre.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Categorie(@Id @GeneratedValue var id: Int? = null, var Nom: String? = null, var Aide: String? = null) {

}