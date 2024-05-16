package com.cursoaristi.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.srodenas.example_with_catalogs.databinding.FragmentPerfilBinding
import com.example.srodenas.example_with_catalogs.ui.viewmodel.perfil.PerfilViewModel

class PerfilFragment : Fragment() {

    private lateinit var viewModel: PerfilViewModel
    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)

        // esto sirve para los datos del usuario desde el ViewModel
        viewModel.userData.observe(viewLifecycleOwner) { user ->
            // Esto es para mostrar los datos del usuario en la interfaz de usuario
            if (user != null) {
                binding.textViewName.text = user.displayName
            }
            if (user != null) {
                binding.textViewEmail.text = user.email
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
