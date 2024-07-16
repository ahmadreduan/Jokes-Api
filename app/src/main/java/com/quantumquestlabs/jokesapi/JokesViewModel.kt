package com.quantumquestlabs.jokesapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JokesViewModel : ViewModel(){

    private val jokesData = MutableLiveData<ResponseJokes>()
    val _jokesData
        get() = jokesData

    init {
        getRandomJokes()
    }

    fun getRandomJokes(){

         viewModelScope.launch {

            val response =  JokesClient.jokesApiService.getJokes()


             if(response.isSuccessful){
                 jokesData.postValue(response.body())
             }

         }

    }


}