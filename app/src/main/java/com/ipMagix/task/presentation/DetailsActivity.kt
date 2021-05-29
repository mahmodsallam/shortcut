package com.ipMagix.task.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.ipMagix.task.R
import com.ipMagix.task.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this , R.layout.activity_details)
        Glide.with(this).load(intent?.getStringExtra("url")).into(binding.ivMovie)
    }
}