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


class UserViewModel (): ViewModel() {
    val login = MutableLiveData<User?>()
    val repository = Repository.repo
    val useCaseLogin = UseCaseLogin(repository)
    val useCaseRegisterLogin = UseCaseRegisterLogin(repository)
    val register = MutableLiveData<Boolean>()

    var usersLiveData= MutableLiveData<MutableList<User>>()
    var posNewUserlLiveData = MutableLiveData<Int>()
    var posDeleteHotelLiveDate = MutableLiveData<Int>()



    fun isLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = useCaseLogin.login(email, password)

            if (user != null) {
                repository.setLoggedUser(user)  // Establecer el usuario logueado en el repositorio
            }

            withContext(Dispatchers.Main) {
                login.postValue(user)
            }
        }
    }





    fun register(user : User){
        var isReg = false

        viewModelScope.launch(Dispatchers.IO) {
            isReg  = useCaseRegisterLogin.register(user)
            withContext(Dispatchers.Main) {
                register.value = isReg
            }
        }
    }
    fun showUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllUsers().map { userEntity ->
                User(
                    id = userEntity.id,
                    name = userEntity.name,
                    email = userEntity.email,
                    passw = userEntity.password,
                    phone = userEntity.phone,
                    imagen = userEntity.imag
                )
            }.toMutableList()

            withContext(Dispatchers.Main) {
                usersLiveData.value = data
            }
        }
    }

    fun addUser(user:User) {
        viewModelScope.launch(Dispatchers.IO) {
            //todo newUserUseCase.setUser(user)
            var pos = 0
            //todo pos  = newUserUseCase()
            if (pos != -1) {

                withContext(Dispatchers.Main) {//Con Dispatchers.Main, indicamos que el hilo se ejecute en el principal.
                    posNewUserlLiveData.value = pos
                }
                showUsers()
            }




            fun deleteUser(pos: Int) {
                //todo deleteUserUseCase.setPos(pos)
                //todo deleteUserUseCase()
                posDeleteHotelLiveDate.value = pos
                showUsers()
            }


            fun getUserForPosition(pos: Int): User? {
                //todo getHUserForPosUseCase.setPos(pos)
                val user = null
                //todo user = getHotelForPosUseCase()
                return user
            }
        }
    }
}











