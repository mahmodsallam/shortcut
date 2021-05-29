package com.ipMagix.task.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ipMagix.task.data.remote.MoviesResponse
import com.ipMagix.task.databinding.ItemMovieBinding

class MoviesAdapter( ) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var  moviesList: List<MoviesResponse.Photos.Photo>?=null
    private lateinit var binding: ItemMovieBinding
    private var context:Context?=null
    private var photoClickListener:PhotoClickListener?=null

    fun setPhotoClickListener(photoClickListener:PhotoClickListener){
        this.photoClickListener=photoClickListener
    }
    fun setMoviesList(moviesList: List<MoviesResponse.Photos.Photo>){
        this.moviesList=moviesList
    }
    fun setContext(context: Context){
        this.context=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList?.size?:0
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val photo = moviesList?.get(position)
        val url = "http://farm${photo?.farm}.static.flickr.com/${photo?.server}/${photo?.id}_${photo?.secret}.jpg"
        with(binding) {
            Glide.with(context!!).load(url)
                .into(ivMovie)
        }
        binding.ivMovie.setOnClickListener { photoClickListener?.onPhotoClickListener(url) }
    }

    class MoviesViewHolder(itemView: ItemMovieBinding) : RecyclerView.ViewHolder(itemView.root)
    interface PhotoClickListener{
        fun onPhotoClickListener(url:String)
    }
}