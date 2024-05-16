package com.cursoaristi.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.srodenas.example_with_catalogs.R
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
        return inflater.inflate(R.layout.fragment_alertas, container, false)
    }
}