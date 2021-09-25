package com.shortcut.comics.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.shortcut.comics.R
import com.shortcut.comics.data.remote.ComicResponse
import com.shortcut.comics.databinding.ActivityDetailsBinding
import com.shortcut.comics.utils.Constants

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this , R.layout.activity_details)
        bindDataToUI()
    }

   private fun bindDataToUI(){
        with(binding){
            Glide.with(this@DetailsActivity).load(intent.getStringExtra(Constants.IMG)).into(ivComicBg)
            tvDesc.text = intent.getStringExtra(Constants.DESC)
            tvTitle.text =intent.getStringExtra(Constants.TITLE)
        }
    }
}