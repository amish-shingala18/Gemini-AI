package com.example.geminiai.helper

import android.app.Activity

class ThemeHelper {

    fun setTheme(activity: Activity,theme:Boolean){
        val pref = activity.getSharedPreferences("theme", Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("theme",theme)
        editor.apply()
    }
    fun getTheme(activity: Activity):Boolean{
        val pref = activity.getSharedPreferences("theme", Activity.MODE_PRIVATE)
        return pref.getBoolean("theme",false)
    }

}