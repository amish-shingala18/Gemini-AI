package com.example.geminiai.domain

import com.example.geminiai.helper.ApiHelper

class DataRepository {
    companion object{
        val repository=DataRepository()
    }
    private val apiHelper = ApiHelper()
    suspend fun getDataRepo(text:String)=apiHelper.callingApi(text)
}