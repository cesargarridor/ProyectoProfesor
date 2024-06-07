package com.example.srodenas.example_with_catalogs.domain.users

import com.example.srodenas.example_with_catalogs.domain.users.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @POST("register")
    suspend fun registerUser(@Body user: User): Response<Boolean>

    @POST("login")
    suspend fun loginUser(@Query("email") email: String, @Query("password") password: String): Response<User?>

    @GET("users")
    suspend fun getAllUsers(): Response<List<User>>
}