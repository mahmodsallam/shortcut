package com.ipMagix.task.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface MoviesRemoteDS {
    @GET("rest/?method=flickr.photos.search&api_key=a202e6968905cddba0fa3382f5f03b5e&tags=movies&format=json&nojsoncallback=1&api_sig=8662c47c36280a17618b167f6b2097d7")
     suspend fun getUsers():MoviesResponse
}