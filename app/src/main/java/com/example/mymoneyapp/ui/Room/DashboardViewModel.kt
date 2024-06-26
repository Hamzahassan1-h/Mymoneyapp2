package com.example.mymoneyapp.ui.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoneyapp.data.api.RetrofitInstance
import com.example.mymoneyapp.data.model.People.PersonModelItemModel
import com.example.mymoneyapp.repository.Repository
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor (
    val repository: Repository
) : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is dashboard Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _personList = MutableLiveData<List<PersonModelItemModel>>()
    val personList: LiveData<List<PersonModelItemModel>> = _personList

    init {
        getPersonList()
    }

    fun getPersonList(){
        viewModelScope.launch {
            val result = RetrofitInstance.apiClient.getPersonList()

            if (!result.isNullOrEmpty()){
                _personList.postValue(result)
            }
        }
    }
}