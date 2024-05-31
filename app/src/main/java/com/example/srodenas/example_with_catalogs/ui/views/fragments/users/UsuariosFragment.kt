package com.cursoaristi.myapplication.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srodenas.example_with_catalogs.R
import com.example.srodenas.example_with_catalogs.databinding.FragmentUsuariosBinding
import com.example.srodenas.example_with_catalogs.ui.viewmodel.users.UserViewModel
import com.example.srodenas.example_with_catalogs.ui.views.fragments.users.adapter.AdapterUser

class UsuariosFragment : Fragment() {

    private var _binding: FragmentUsuariosBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: UserViewModel
    private lateinit var adapterUser: AdapterUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsuariosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.myRecyclerViewUsers.layoutManager = LinearLayoutManager(context)
        adapterUser = AdapterUser(mutableListOf()) { position ->

        }
        binding.myRecyclerViewUsers.adapter = adapterUser

        userViewModel.usersLiveData.observe(viewLifecycleOwner, Observer { users ->
            users?.let {
                adapterUser.listUsers = it
                adapterUser.notifyDataSetChanged()
            }
        })

        userViewModel.showUsers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
