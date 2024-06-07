package com.example.srodenas.example_with_catalogs.domain.users.models


import com.example.srodenas.example_with_catalogs.domain.users.RetrofitClient
import com.example.srodenas.example_with_catalogs.domain.users.UserService

class Repository private constructor() {
    private val userService: UserService = RetrofitClient.instance.create(UserService::class.java)

    companion object {
        val repo: Repository by lazy {
            Repository()
        }
    }

    private var loggedUser: User? = null

    fun setLoggedUser(user: User) {
        loggedUser = user
    }

    fun getLoggedUser(): User? {
        return loggedUser
    }

    suspend fun isLoginEntity(email: String, password: String): User? {
        val response = userService.loginUser(email, password)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

    suspend fun registerEntity(user: User): Boolean {
        val response = userService.registerUser(user)
        return response.isSuccessful && response.body() == true
    }

    suspend fun getAllUsers(): List<User> {
        val response = userService.getAllUsers()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
