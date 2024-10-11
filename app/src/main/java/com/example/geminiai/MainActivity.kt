package com.example.geminiai

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geminiai.view.adapter.GeminiAdapter
import com.example.geminiai.databinding.ActivityMainBinding
import com.example.geminiai.helper.DbHelper.Companion.initDb
import com.example.geminiai.helper.ThemeHelper
import com.example.geminiai.viewModel.GeminiViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var geminiAdapter: GeminiAdapter
    private  var themeHelper = ThemeHelper()
    private val geminiViewModel by viewModels<GeminiViewModel>()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        geminiViewModel.dataList.observe(this){
            geminiAdapter = GeminiAdapter(it)
            binding.rvGemini.adapter = geminiAdapter
            binding.rvGemini.scrollToPosition(it.size-1)
        }

        binding.imgSend.setOnClickListener {
            geminiViewModel.addQuestion(binding.edtSendMessage.text.toString())
            geminiViewModel.getGeminiData(binding.edtSendMessage.text.toString())
            binding.edtSendMessage.setText("")
        }
        geminiViewModel.startTheme(this)
        initDb(this)
        val theme = this.let { themeHelper.getTheme(it) }
        binding.msTheme.isChecked = theme
        binding.imgMenu.setOnClickListener {
            binding.main.open()
        }
        binding.msTheme.setOnClickListener {
            geminiViewModel.addTheme(binding.msTheme.isChecked)
            themeHelper.setTheme(this,binding.msTheme.isChecked)
        }
    }
}