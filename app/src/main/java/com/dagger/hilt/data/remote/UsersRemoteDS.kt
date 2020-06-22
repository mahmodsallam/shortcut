package com.dagger.hilt.data.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface UsersRemoteDS {
    @GET("users")
     fun getUsers():Call<List<User>>
}