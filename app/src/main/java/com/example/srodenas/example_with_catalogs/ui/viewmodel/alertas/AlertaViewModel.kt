package com.example.srodenas.example_with_catalogs.ui.viewmodel.alertas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlertaViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Alertas"
    }
    val text : LiveData<String> = _text  //recordamos que LiveData es una clase Abstracta.
}