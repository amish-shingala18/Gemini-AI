package com.example.geminiai.domain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private var BASEURL="https://generativelanguage.googleapis.com/"
        private var retrofit:Retrofit?=null
        fun getApi():Retrofit{
            if (retrofit==null){
                retrofit=Retrofit.Builder().baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}