package com.example.desgignchapter.data.repository

import android.util.Log
import com.example.desgignchapter.data.model.RegisterResponse
import com.example.desgignchapter.data.model.UserResponse
import com.example.desgignchapter.data.network.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.RequestBody
import retrofit2.Response

class UserRepository(private val api:UserApi) {

    fun getUser(): Flow<Response<UserResponse>> = flow {
        try {
            val response = api.getUser()
            if (response.isSuccessful) {
                emit(response)
            } else {
                Log.e("TAG", "getUser: ${response.message()}")
            }
        }catch (e: Exception) {
            Log.e("TAG", "getUser: ${e.message}")
        }
    }.flowOn(Dispatchers.IO)

    fun registerUser(requestBody: RegisterResponse): Flow<Response<RegisterResponse>> = flow {
        try {
            val response = api.Register(requestBody)
            if (response.isSuccessful) {
                emit(response)
            } else {
                Log.e("TAG", "registerUser: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("TAG", "registerUser: ${e.message}")
        }
    }.flowOn(Dispatchers.IO)




}