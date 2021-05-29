package com.ipMagix.task.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipMagix.task.data.remote.Movie
import com.ipMagix.task.data.remote.MoviesResponse
import com.ipMagix.task.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel @ViewModelInject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {
    private var _usersList = MutableLiveData<MoviesResponse>()
    val usersList = _usersList

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO){
            try{
                val result =   moviesRepository.getUsers()
                _usersList.postValue(result)
            }
            catch (e:Exception){
                Log.d("Exception" , e.message)
            }
        }
    }
}