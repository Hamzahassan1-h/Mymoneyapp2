package com.example.mymoneyapp.data.api

import com.example.mymoneyapp.data.model.People.PersonModelItemModel
import com.example.mymoneyapp.data.model.Room.RoomItemModel
import retrofit2.http.GET

interface ApiEndPoint {

    @GET(ApiDetail.PERSON_ENDPOINT)
    suspend fun getPersonList(): List<PersonModelItemModel>

    @GET(ApiDetail.ROOM_LIST_ENDPOINT)
    suspend fun getRoomList(): List<RoomItemModel>
}