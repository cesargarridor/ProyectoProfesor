package com.example.srodenas.example_with_catalogs.data.users.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.srodenas.example_with_catalogs.data.users.database.dao.UserDao
import com.example.srodenas.example_with_catalogs.data.users.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDataBase : RoomDatabase(){
    abstract fun userDao(): UserDao
    companion object {

        //he creado este metodo para insertar usuarios de prueba
        private suspend fun insertTestUsers(userDao: UserDao?) {
            val testUsers = listOf(
                UserEntity(id = 1, name = "a", email = "a", password = "a", phone = "123456789", imag = "a"),
                UserEntity(id = 2, name = "aa", email = "aa", password = "a", phone = "987654321", imag = "a")
            )

            userDao?.insertUser(*testUsers.toTypedArray())
        }
    }
}