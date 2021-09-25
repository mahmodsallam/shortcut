package com.shortcut.comics.data.repository

import com.shortcut.comics.data.remote.ComicResponse

interface IComicsRepository {
    suspend fun getComicByNumber(id:String): ComicResponse

}