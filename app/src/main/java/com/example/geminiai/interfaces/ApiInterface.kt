package com.example.geminiai.interfaces

import com.example.geminiai.model.GeminiModel
import com.example.geminiai.model.PartsItem
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {


    @POST("v1beta/models/gemini-1.5-flash:generateContent")
    fun getData(
        @Query("key") key:String="AIzaSyAzw5rQc41TiKdoQlWiv2i192jc1t0oxbI",
        @Header("Content-Type") h1:String="application/json",
        @Body body:RequestBody
    ) : Call<GeminiModel>
}