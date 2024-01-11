package com.example.desgignchapter.data.model

import com.google.gson.annotations.SerializedName


data class RegisterResponse(
    val email: String,
    val name: String,
    val password: String
)