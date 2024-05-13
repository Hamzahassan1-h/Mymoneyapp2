package com.example.mymoneyapp.ui.People

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mymoneyapp.R
import com.example.mymoneyapp.data.model.Room.RoomItemModel
import com.example.mymoneyapp.databinding.ItemRoomBinding

class HomeAdapter(
    val roomList : List<RoomItemModel>,
    val function : (RoomItemModel) -> Unit
) : Adapter<HomeAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView : View) : ViewHolder(itemView){
        val binding = ItemRoomBinding.bind(itemView)
        fun updateUi (RoomItemModel: RoomItemModel) {
            binding.apply {
                tvIdentification.text = RoomItemModel.id
                tvStatus.text = RoomItemModel.isOccupied.toString()
                tvCapacity.text = RoomItemModel.maxOccupancy.toString()
                tvDetails.text = RoomItemModel.createdAt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        )

    }

    override fun getItemCount() = roomList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUi(roomList[position])

    }
}