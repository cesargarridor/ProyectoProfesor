package com.example.srodenas.example_with_catalogs.ui.views.fragments.users.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.srodenas.example_with_catalogs.R
import com.example.srodenas.example_with_catalogs.databinding.ItemUserBinding
import com.example.srodenas.example_with_catalogs.domain.users.models.User

class AdapterUser(
    var listUsers: MutableList<User>,
    val onDetails: (Int) -> Unit
) : RecyclerView.Adapter<AdapterUser.ViewHUser>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHUser {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemUser = R.layout.item_user
        return ViewHUser(layoutInflater.inflate(layoutItemUser, parent, false), onDetails)
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: ViewHUser, position: Int) {
        holder.renderize(listUsers[position], position)
    }

    inner class ViewHUser(view: View, val onDetails: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
        private val binding = ItemUserBinding.bind(view)

        fun renderize(user: User, position: Int) {
            binding.txtviewName.text = user.name
            binding.txtviewPhone.text = user.phone
            binding.txtViewEmail.text = user.email

            binding.btnDetail.setOnClickListener {
                onDetails(position)
            }
        }
    }
}
