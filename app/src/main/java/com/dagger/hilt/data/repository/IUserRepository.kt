package com.dagger.hilt.data.repository

import com.dagger.hilt.data.remote.User
import retrofit2.Call

interface IUserRepository {
    fun getUsers(): Call<List<User>>
}