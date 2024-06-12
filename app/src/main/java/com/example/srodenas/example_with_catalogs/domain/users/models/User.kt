package com.example.srodenas.example_with_catalogs.domain.users.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Modelo de datos para un usuario
class User {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("disponible")
    @Expose
    var disponible: Int? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("nombre")
    @Expose
    var nombre: String? = null

    @SerializedName("imagen")
    @Expose
    var imagen: String? = null

    @SerializedName("token")
    @Expose
    var token: String? = null
}
