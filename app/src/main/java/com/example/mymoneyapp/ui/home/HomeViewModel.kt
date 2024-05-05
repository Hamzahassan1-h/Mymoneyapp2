package com.example.mymoneyapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoneyapp.data.api.RetrofitInstance
import com.example.mymoneyapp.data.model.Room.RoomItemModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _roomList = MutableLiveData<List<RoomItemModel>>()
    val roomList : LiveData<List<RoomItemModel>> = _roomList

    init {
        getRoomList()
    }

    fun getRoomList(){
        viewModelScope.launch {
            val result = RetrofitInstance.apiClient.getRoomList()

            if (!result.isNullOrEmpty()){
                _roomList.postValue(result)
            }
        }
    }
}