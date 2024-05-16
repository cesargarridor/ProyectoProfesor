package com.example.srodenas.example_with_catalogs.ui.viewmodel.perfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class PerfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Perfil"
    }
    val text: LiveData<String> = _text
    private val _userData = MutableLiveData<FirebaseUser?>()
    val userData: MutableLiveData<FirebaseUser?> = _userData

  /**  init {
        loadUserData()
    }

    private fun loadUserData() {
        // Obtener el usuario actualmente autenticado
        val currentUser = FirebaseAuth.getInstance().currentUser
        _userData.value = currentUser
    }**/
}