package fr.epf.demoseptembre.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

//une ville est entrée par l'admin en bdd

@Entity
data class Ville(@Id @GeneratedValue var id: Int? = null, var Nom: String? = null, var Pays: String? = null, var Image: String? = null) {

}
