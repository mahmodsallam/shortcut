package com.dagger.hilt.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dagger.hilt.data.remote.User
import com.dagger.hilt.data.repository.UsersRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel @ViewModelInject constructor(private val usersRepository: UsersRepository) :
    ViewModel() {
    private var _usersList = MutableLiveData<List<User>>()
    val usersList = _usersList

    fun getUsers() {
        usersRepository.getUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("ERROR", t.message)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                _usersList.value = response.body()
            }
        })
    }
}