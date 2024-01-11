package com.example.desgignchapter.data.model

data class UserResponse(
    val result: List<User>
){
    data class User(
        val created_at: String,
        val email: String,
        val email_verified_at: Any,
        val id: Int,
        val name: String,
        val updated_at: String,
        val password:String
    )
}