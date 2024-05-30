package com.example.srodenas.example_with_catalogs.ui.views.fragments.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.srodenas.example_with_catalogs.databinding.ItemUserBinding
import com.example.srodenas.example_with_catalogs.domain.users.models.User

class ViewHUser(view: View, val onDetails: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
    private val binding = ItemUserBinding.bind(view)

    fun renderize(user: User, position: Int) {
        binding.txtviewName.text = user.name
        binding.txtviewPhone.text = user.phone
        // Set other fields as needed

        binding.btnDetail.setOnClickListener {
            onDetails(position)
        }
    }
}
