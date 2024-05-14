package com.example.srodenas.example_with_catalogs.ui.views.activities

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.srodenas.example_with_catalogs.databinding.ActivityLoginBinding
import com.example.srodenas.example_with_catalogs.domain.users.models.User
import com.example.srodenas.example_with_catalogs.ui.viewmodel.users.UserViewModel
import com.example.srodenas.example_with_catalogs.ui.views.fragments.users.dialogs.DialogRegisterUser


class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var userViewModel : UserViewModel // Declaración del UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        registerLiveData()
        initEvent()
    }

    private fun initEvent() {
        binding.btnLogin.setOnClickListener{
            userViewModel.isLogin(binding.txtEmail.text.toString(), binding.txtPassword.text.toString())

        }
        binding.btnRegistro.setOnClickListener{
            val dialog = DialogRegisterUser(){
                user -> okOnRegisterUser(user)   //Ya tengo el nuevo usuario capturado.
            }
            dialog.show(this.supportFragmentManager, "Registro de nuevo usuario")

        }
    }

    private fun okOnRegisterUser(user: User) {
        userViewModel.register(user)
    }

    private fun registerLiveData() {
        userViewModel.login.observe(this,
            {
            login->
                if (login!=null) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Error en el logueo", Toast.LENGTH_LONG).show()
                }
            }
        )

        userViewModel.register.observe(this,{
            register->
                if (register)
                    Toast.makeText(this, "Usuario registrado correctaemente", Toast.LENGTH_LONG).show()
                 else
                    Toast.makeText(this, "Usuario No registrado", Toast.LENGTH_LONG).show()

        })
    }
}