package com.example.mymoneyapp.repository

import com.example.mymoneyapp.data.model.People.PersonModelItemModel
import com.example.mymoneyapp.data.model.Room.RoomItemModel

interface Repository {

    suspend fun getPersonList(): List<PersonModelItemModel>

    suspend fun getRoomList(): List<RoomItemModel>
}