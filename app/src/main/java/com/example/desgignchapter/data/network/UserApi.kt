package com.example.desgignchapter.data.network

import com.example.desgignchapter.data.model.RegisterResponse
import com.example.desgignchapter.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @GET("/api/user")
    suspend fun getUser():Response<UserResponse>

    @POST("/api/register")
    suspend fun Register(@Body requestBody: RegisterResponse): Response<RegisterResponse>

}