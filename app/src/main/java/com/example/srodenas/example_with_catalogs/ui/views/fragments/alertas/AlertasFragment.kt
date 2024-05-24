package com.cursoaristi.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.srodenas.example_with_catalogs.R
import com.example.srodenas.example_with_catalogs.databinding.FragmentAlertasBinding
import com.example.srodenas.example_with_catalogs.domain.alerts.models.Alert
import com.example.srodenas.example_with_catalogs.domain.users.models.User
import com.example.srodenas.example_with_catalogs.ui.viewmodel.alertas.AlertaViewModel
import com.example.srodenas.example_with_catalogs.ui.views.fragments.alertas.dialogs.AddAlert
import com.example.srodenas.example_with_catalogs.ui.views.fragments.users.dialogs.DialogRegisterUser

class AlertasFragment : Fragment() {
    private var _binding: FragmentAlertasBinding? = null
    private val binding get() = _binding!!
    private val viewModelAlerts: AlertaViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlertasBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvent()
    }

    private fun initEvent() {
        binding.btnAdd.setOnClickListener {
            val dialog = AddAlert { alert ->
                okOnAddAlert(alert)
            }
            dialog.show(requireActivity().supportFragmentManager, "Agregar Alerta")
        }
    }
    private fun okOnAddAlert(alert: Alert) {
        viewModelAlerts.addAlert(alert)
        Toast.makeText(requireContext(), "Alerta agregada correctamente", Toast.LENGTH_LONG).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}