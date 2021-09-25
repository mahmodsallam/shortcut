package com.shortcut.comics.data.remote

data class ComicResponse(
    val alt: String, // Poisson distributions have no value over negative numbers
    val day: String, // 1
    val img: String, // https://imgs.xkcd.com/comics/poisson.jpg
    val link: String,
    val month: String, // 1
    val news: String,
    val num: Int, // 12
    val safe_title: String, // Poisson
    val title: String, // Poisson
    val transcript: String, // [[A stick figure says to another black-hat-wearing figure.]]Man: I'm a poisson distribution!Man: Still a poisson distribution.Hat Guy: What the hell, man.  Why do you keep saying that?Man: Because I'm totally a poisson distribution.Hat Guy: I'm less than zero.[[Man is gone; Hat Guy is whistling.]]{{alt text: Poisson distributions have no value over negative numbers}}
    val year: String // 2006
)