package com.ipMagix.task.data.repository

import com.ipMagix.task.data.remote.Movie
import com.ipMagix.task.data.remote.MoviesResponse
import retrofit2.Call

interface IMoviesRepository {
    suspend fun getUsers(): MoviesResponse
}