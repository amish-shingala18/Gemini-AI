package com.example.geminiai.helper

import android.util.Log
import com.example.geminiai.domain.ApiClient.Companion.getApi
import com.example.geminiai.interfaces.ApiInterface
import com.example.geminiai.model.GeminiModel
import com.example.geminiai.model.PartsItem
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.awaitResponse

class ApiHelper {
    suspend fun callingApi(text:String): GeminiModel? {
        val mediaType = MediaType.parse("application/json")
        val requestBody= RequestBody.create(mediaType,
            "{\"contents\": [{\"parts\":[{\"text\": \"$text\"}]}]}")
        val retrofit= getApi().create(ApiInterface::class.java)
        val response=retrofit.getData(body = requestBody).awaitResponse()
        if(response.isSuccessful){
            Log.d("TAG", "callingApi: ${response.body()}")
            return response.body()
        }
        Log.d("TAG", "callingApi: ${response.body()}")
        return null
    }
}
/*var geminiText:String?= null
    var geminiTextList= mutableListOf<PartsItem>()*/