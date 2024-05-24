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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srodenas.example_with_catalogs.R
import com.example.srodenas.example_with_catalogs.databinding.FragmentAlertasBinding
import com.example.srodenas.example_with_catalogs.domain.alerts.models.Alert
import com.example.srodenas.example_with_catalogs.domain.users.models.User
import com.example.srodenas.example_with_catalogs.ui.viewmodel.alertas.AlertaViewModel
import com.example.srodenas.example_with_catalogs.ui.views.fragments.alertas.dialogs.AddAlert
import com.example.srodenas.example_with_catalogs.ui.views.fragments.alerts.adapter.AdapterAlerts
import com.example.srodenas.example_with_catalogs.ui.views.fragments.users.dialogs.DialogRegisterUser

class AlertasFragment : Fragment() {
    private var _binding: FragmentAlertasBinding? = null
    private val binding get() = _binding!!
    private val viewModelAlerts: AlertaViewModel by viewModels()

    private lateinit var adapterAlerts: AdapterAlerts

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlertasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initEvent()
    }

    private fun initRecyclerView() {
        adapterAlerts = AdapterAlerts(ArrayList(), onDelete = {
            deleteAlert(it)
        }, onDetails = {
            // Handle details action here
        })
        binding.myRecyclerViewAlerts.layoutManager = LinearLayoutManager(requireContext())
        binding.myRecyclerViewAlerts.adapter = adapterAlerts
    }

    private fun initEvent() {
        binding.btnAdd.setOnClickListener {
            val dialog = AddAlert { alert ->
                okOnAddAlert(alert)
            }
            dialog.show(requireActivity().supportFragmentManager, "Agregar Alerta")
        }

        viewModelAlerts.alerts.observe(viewLifecycleOwner, { alerts ->
            adapterAlerts.listAlerts.clear()
            adapterAlerts.listAlerts.addAll(alerts)
            adapterAlerts.notifyDataSetChanged()
        })
    }
    private fun okOnAddAlert(alert: Alert) {
        val newAlert = Alert(
            userId = 0, // Ajusta este valor según sea necesario
            textShort = alert.textShort, // Utiliza el campo 'name' para 'textShort'
            message = alert.message, // Utiliza el campo 'detailedDescription' para 'message'
            alertDate = alert.alertDate // Utiliza el campo 'date' para 'alertDate'
        )
        viewModelAlerts.addAlert(newAlert)
        Toast.makeText(requireContext(), "Alerta agregada correctamente", Toast.LENGTH_LONG).show()
    }

    private fun deleteAlert(position: Int) {
        viewModelAlerts.deleteAlert(position)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}