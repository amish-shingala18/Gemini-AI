package com.example.geminiai.view.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geminiai.R
import com.example.geminiai.databinding.GeminiSampleBinding
import com.example.geminiai.model.PartsItem

class GeminiAdapter(private var list: MutableList<PartsItem>) : RecyclerView.Adapter<GeminiAdapter.GeminiViewHolder>() {
    class GeminiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sampleBinding = GeminiSampleBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeminiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gemini_sample,parent,false)
        return GeminiViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: GeminiViewHolder, position: Int) {
        holder.sampleBinding.txtSampleMessage.text=list[position].text
        if (position%2==0){
            holder.sampleBinding.txtSampleMessage.setBackgroundResource(R.drawable.user_text)
            holder.sampleBinding.lnrGemini.gravity=Gravity.END
            holder.sampleBinding.txtSampleMessage.setTextColor(Color.WHITE)
            holder.sampleBinding.cvUser.visibility=View.VISIBLE
            holder.sampleBinding.cvGemini.visibility=View.GONE
        }else{
            holder.sampleBinding.txtSampleMessage.setBackgroundResource(R.drawable.gemini_text)
            holder.sampleBinding.lnrGemini.gravity=Gravity.START
            holder.sampleBinding.cvUser.visibility=View.GONE
            holder.sampleBinding.cvGemini.visibility=View.VISIBLE
        }
    }
}