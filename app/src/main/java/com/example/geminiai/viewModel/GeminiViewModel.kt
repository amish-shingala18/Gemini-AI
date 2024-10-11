package com.example.geminiai.viewModel

import android.app.Activity
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geminiai.domain.DataRepository.Companion.repository
import com.example.geminiai.helper.ThemeHelper
import com.example.geminiai.model.PartsItem
import kotlinx.coroutines.launch

class GeminiViewModel : ViewModel() {
   private var geminiTextList= MutableLiveData<MutableList<PartsItem>>()
    var dataList:LiveData<MutableList<PartsItem>> = geminiTextList

    private var dummyList = mutableListOf<PartsItem>()
    fun addQuestion(qa:String)
    {
        dummyList.add(PartsItem(qa))
        geminiTextList.value = dummyList
    }
    fun getGeminiData (searchedText:String){
        viewModelScope.launch {
            val data = repository.getDataRepo(searchedText)
            Log.e("TAG", "getGeminiData: ==== $data" )
            dummyList.add(PartsItem(data!!.candidates!![0]!!.content?.parts?.get(0)!!.text))
            geminiTextList.value = dummyList
        }
    }


    
    private var themeHelper = ThemeHelper()
    fun addTheme(theme:Boolean){
        if (theme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
    fun startTheme(activity: Activity){
        val theme = themeHelper.getTheme(activity)
        if (theme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }


}