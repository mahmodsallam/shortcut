package com.ipMagix.task.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ipMagix.task.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getUsers()
        mainViewModel.usersList.observe(this, Observer {
            adapter = MoviesAdapter()
            adapter.setMoviesList(it.photos.photo)
            adapter.setContext(this)
            rvUsers.adapter = adapter
            rvUsers.layoutManager=LinearLayoutManager(this)
        })
    }
}