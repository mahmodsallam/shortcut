package com.ipMagix.task.data.repository

import com.ipMagix.task.data.remote.MoviesRemoteDS
import com.ipMagix.task.data.remote.MoviesResponse
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesRemoteDS: MoviesRemoteDS) : IMoviesRepository {
    override suspend fun getUsers(): MoviesResponse {
        return moviesRemoteDS.getUsers()
    }
}