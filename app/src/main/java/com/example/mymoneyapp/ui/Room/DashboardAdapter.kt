package com.example.mymoneyapp.ui.Room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymoneyapp.data.model.People.PersonModelItemModel
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mymoneyapp.R
import com.example.mymoneyapp.databinding.ItemPersonBinding

class DashboardAdapter(
    val personList: List<PersonModelItemModel>,
    param: (Any) -> Unit,
) : Adapter<DashboardAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView: View):ViewHolder(itemView) {
        val binding = ItemPersonBinding.bind(itemView)
        fun updateUI (PersonModelItemModel : PersonModelItemModel) {
            //handle the UI changes based on current data
            binding.apply {
                Glide.with(itemView.context).load(PersonModelItemModel.avatar).placeholder(R.drawable.baseline_account_circle_24).into(tvProfile)
                tvTitle.text = PersonModelItemModel.jobtitle
                tvName.text = PersonModelItemModel.name
                tvEmail.text = PersonModelItemModel.email
                tvColor.text = PersonModelItemModel.favouriteColor

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent,false )
        )
    }

    override fun getItemCount() = personList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(personList[position])
    }
}