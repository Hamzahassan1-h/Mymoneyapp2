package com.example.mymoneyapp.repository

import com.example.mymoneyapp.data.api.ApiEndPoint
import com.example.mymoneyapp.data.model.People.PersonModelItemModel
import com.example.mymoneyapp.data.model.Room.RoomItemModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val apiDetail:ApiEndPoint
) : Repository {

    override suspend fun getPersonList(): List<PersonModelItemModel> = apiDetail.getPersonList()

    override suspend fun getRoomList(): List<RoomItemModel> {
        return apiDetail.getRoomList()
    }
}