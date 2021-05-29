package com.ipMagix.task.data.repository

import com.ipMagix.task.data.remote.MoviesResponse

interface IMoviesRepository {
    suspend fun getUsers(): MoviesResponse
}