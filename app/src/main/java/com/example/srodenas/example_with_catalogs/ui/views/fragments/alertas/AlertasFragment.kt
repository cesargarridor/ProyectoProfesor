package com.cursoaristi.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.srodenas.example_with_catalogs.databinding.FragmentAlertasBinding
import com.example.srodenas.example_with_catalogs.ui.viewmodel.alertas.AlertaViewModel

class AlertasFragment : Fragment() {
    private var binding : FragmentAlertasBinding ? = null
    private val viewModelAlerts : AlertaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlertasBinding.inflate(inflater, container, false)
        val root : View = binding!!.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = binding!!.textDashboard
        viewModelAlerts.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}