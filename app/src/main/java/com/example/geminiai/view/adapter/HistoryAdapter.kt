package com.example.geminiai.view.adapter

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geminiai.R
import com.example.geminiai.databinding.GeminiSampleBinding
import com.example.geminiai.model.HistoryEntity

class HistoryAdapter(private var list:MutableList<HistoryEntity>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sampleBinding = GeminiSampleBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gemini_sample,parent,false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.sampleBinding.txtSampleMessage.text=list[position].historyText
        if (position%2==0){
            holder.sampleBinding.txtSampleMessage.setBackgroundResource(R.drawable.user_text)
            holder.sampleBinding.lnrGemini.gravity= Gravity.END
            holder.sampleBinding.txtSampleMessage.setTextColor(R.color.md_theme_primaryContainer)
            holder.sampleBinding.cvUser.visibility=View.VISIBLE
            holder.sampleBinding.cvGemini.visibility=View.GONE
        }else{
            holder.sampleBinding.txtSampleMessage.setBackgroundResource(R.drawable.gemini_text)
            holder.sampleBinding.lnrGemini.gravity= Gravity.START
            holder.sampleBinding.cvUser.visibility=View.GONE
            holder.sampleBinding.cvGemini.visibility=View.VISIBLE
        }
    }
}