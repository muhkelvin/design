package com.example.desgignchapter.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.desgignchapter.data.model.RegisterResponse
import com.example.desgignchapter.data.model.UserResponse
import com.example.desgignchapter.data.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: UserRepository):ViewModel() {

    val userData:LiveData<Response<UserResponse>> = repository.getUser().asLiveData()

    private val _registerStatus = MutableLiveData<Response<RegisterResponse>>()
    val registerStatus: LiveData<Response<RegisterResponse>> = _registerStatus

    fun register(registerRequest: RegisterResponse) {
        viewModelScope.launch {
            repository.registerUser(registerRequest)
                .collect { response ->
                    _registerStatus.value = response
                }
        }
    }

    class Factory(private val repository: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java))
                return UserViewModel(repository) as T
            throw RuntimeException("No Viewmodel")
        }
    }



}