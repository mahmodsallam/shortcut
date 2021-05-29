package com.ipMagix.task.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ipMagix.task.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , MoviesAdapter.PhotoClickListener {
    private val mainViewModel: MainViewModel by viewModels()
    private  var adapter = MoviesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getUsers()
        mainViewModel.usersList.observe(this, Observer {
            adapter.setMoviesList(it.photos.photo)
            adapter.setContext(this)
            adapter.setPhotoClickListener(this)
            rvUsers.adapter = adapter
            rvUsers.layoutManager=LinearLayoutManager(this)
        })
    }

    override fun onPhotoClickListener(url: String) {
        val intent = Intent(this , DetailsActivity::class.java)
        intent.putExtra("url"  , url)
        startActivity(intent)
    }

}