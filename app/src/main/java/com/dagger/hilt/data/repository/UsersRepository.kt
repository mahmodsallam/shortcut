package com.dagger.hilt.data.repository

import com.dagger.hilt.data.remote.User
import com.dagger.hilt.data.remote.UsersRemoteDS
import retrofit2.Call
import javax.inject.Inject

class UsersRepository @Inject constructor(private val usersRemoteDS: UsersRemoteDS) : IUserRepository {
    override fun getUsers(): Call<List<User>> {
        return usersRemoteDS.getUsers()
    }
}