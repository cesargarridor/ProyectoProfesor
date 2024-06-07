package com.example.srodenas.example_with_catalogs.ui.viewmodel.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.srodenas.example_with_catalogs.domain.users.models.ListUsers
import com.example.srodenas.example_with_catalogs.domain.users.models.Repository
import com.example.srodenas.example_with_catalogs.domain.users.models.User
import com.example.srodenas.example_with_catalogs.domain.users.usecase.UseCaseLogin
import com.example.srodenas.example_with_catalogs.domain.users.usecase.UseCaseRegisterLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {
    val login = MutableLiveData<User?>()
    val repository = Repository.repo
    val useCaseLogin = UseCaseLogin(repository)
    val useCaseRegisterLogin = UseCaseRegisterLogin(repository)
    val register = MutableLiveData<Boolean>()

    var usersLiveData = MutableLiveData<MutableList<User>>()
    var posNewUserLiveData = MutableLiveData<Int>()
    var posDeleteUserLiveDate = MutableLiveData<Int>()

    fun isLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = useCaseLogin.login(email, password)
            if (user != null) {
                repository.setLoggedUser(user)
            }
            withContext(Dispatchers.Main) {
                login.postValue(user)
            }
        }
    }

    fun register(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val isReg = useCaseRegisterLogin.register(user)
            withContext(Dispatchers.Main) {
                register.value = isReg
            }
        }
    }

    fun showUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllUsers().toMutableList()
            withContext(Dispatchers.Main) {
                usersLiveData.value = data
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            // Implementación de agregar usuario con Retrofit
            // ...
        }
    }

    fun deleteUser(pos: Int) {
        // Implementación de eliminar usuario con Retrofit
        // ...
    }

    fun getUserForPosition(pos: Int): User? {
        // Implementación de obtener usuario por posición con Retrofit
        // ...
        return null
    }
}
