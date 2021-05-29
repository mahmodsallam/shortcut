package com.ipMagix.task.data.remote

import com.squareup.moshi.Json

data class Movie(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "email")
    val email: String = " ",
    @Json(name = "avatar")
    val avatar: String = ""
)