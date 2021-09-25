package com.shortcut.comics.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ComicsRemoteDS {
    @GET("{id}/info.0.json")
     suspend fun getComicByNumber(@Path("id") id:String):ComicResponse
}