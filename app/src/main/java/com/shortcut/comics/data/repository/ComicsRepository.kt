package com.shortcut.comics.data.repository

import com.shortcut.comics.data.remote.ComicResponse
import com.shortcut.comics.data.remote.ComicsRemoteDS
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val comicsRemoteDS: ComicsRemoteDS) : IComicsRepository {
    override suspend fun getComicByNumber(id:String): ComicResponse {
        return comicsRemoteDS.getComicByNumber(id)
    }
}