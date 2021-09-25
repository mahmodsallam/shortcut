package com.shortcut.comics.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.shortcut.comics.R
import com.shortcut.comics.data.remote.ComicResponse
import com.shortcut.comics.databinding.ActivityMainBinding
import com.shortcut.comics.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var comicResponse: ComicResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.etSearch.doAfterTextChanged {
            GlobalScope.launch {
                delay(1000)
                mainViewModel.getComicByNumber(it?.toString() ?: "1")
            }
        }

        mainViewModel.usersList.observe(this, Observer {
            binding.layoutComic.visibility = View.VISIBLE
            Glide.with(this).load(it.img).into(binding.ivComic)
            binding.tvComicName.text = it.title
            binding.tvComicSaveName.text = it.alt
            comicResponse = it

        })

        binding.layoutComic.setOnClickListener {
            openComicDetails(comicResponse)
        }
    }


    private fun openComicDetails(comicResponse: ComicResponse) {
        var intent = Intent(this, DetailsActivity::class.java)
        var bundle = Bundle()
        bundle.putString(Constants.IMG, comicResponse.img)
        bundle.putString(Constants.TITLE, comicResponse.title)
        bundle.putString(Constants.DESC, comicResponse.transcript)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}