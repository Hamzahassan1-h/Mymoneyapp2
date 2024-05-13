package com.example.mymoneyapp.ui.People

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoneyapp.data.api.RetrofitInstance
import com.example.mymoneyapp.data.model.Room.RoomItemModel
import com.example.mymoneyapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (

    val repository: Repository

): ViewModel() {

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