package az.company.microservice.model

import jakarta.persistence.Entity

@Entity
 data class User  (
     var id:Long,
     val name:String,
     val surname:String,
     val email:String,
     val age:Int


 )