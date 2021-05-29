package com.ipMagix.task.data.remote

data class MoviesResponse(
    val photos: Photos,
    val stat: String // ok
) {
    data class Photos(
        val page: Int, // 1
        val pages: String, // 4946
        val perpage: Int, // 100
        val photo: List<Photo>,
        val total: String // 494551
    ) {
        data class Photo(
            val farm: Int, // 66
            val id: String, // 51210961995
            val isfamily: Int, // 0
            val isfriend: Int, // 0
            val ispublic: Int, // 1
            val owner: String, // 148179219@N03
            val secret: String, // 24f1303a46
            val server: String, // 65535
            val title: Any // null
        )
    }
}