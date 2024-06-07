package com.example.srodenas.example_with_catalogs.domain.users.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("passw")
    @Expose
    var passw: String? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("imagen")
    @Expose
    var imagen: String? = null
)