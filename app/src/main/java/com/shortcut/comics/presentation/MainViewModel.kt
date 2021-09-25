package com.shortcut.comics.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shortcut.comics.data.remote.ComicResponse
import com.shortcut.comics.data.repository.ComicsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val moviesRepository: ComicsRepository) :
    ViewModel() {
    private var _usersList = MutableLiveData<ComicResponse>()
    val usersList = _usersList

    fun getComicByNumber(id:String) {
        viewModelScope.launch(Dispatchers.IO){
            try{
                val result =   moviesRepository.getComicByNumber(id)
                _usersList.postValue(result)
            }
            catch (e:Exception){
                Log.d("Exception" , e.message)
            }
        }
    }
}