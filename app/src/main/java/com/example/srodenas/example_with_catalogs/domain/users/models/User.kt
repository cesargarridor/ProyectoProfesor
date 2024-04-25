package com.example.srodenas.example_with_catalogs.domain.users.models


data class User (var id: Int,
                 var name: String,
                 var email:String,
                 var passw:String,
                 var phone:String,
                 var imagen: String
){

    //constructor primario
    constructor(email: String, passw: String):
            this(0, "", email, passw, "", "")

}
