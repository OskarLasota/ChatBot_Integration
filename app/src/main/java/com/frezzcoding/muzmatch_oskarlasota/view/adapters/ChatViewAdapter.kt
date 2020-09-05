package com.frezzcoding.muzmatch_oskarlasota.view.adapters

import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.frezzcoding.muzmatch_oskarlasota.R
import com.frezzcoding.muzmatch_oskarlasota.databinding.ChatCardviewBinding
import com.frezzcoding.muzmatch_oskarlasota.models.ChatMessage

class ChatViewAdapter(private val _data : List<ChatMessage>) : RecyclerView.Adapter<ChatViewAdapter.ViewHolder>(){

    private lateinit var binding : ChatCardviewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater : LayoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.chat_cardview, parent, false)

        return ViewHolder(binding)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message : ChatMessage = _data[position]
        if(position>0){
            holder.bind(message, _data[position-1])
        }else {
            holder.bindFirst(message)
        }
    }


    class ViewHolder(private val binding: ChatCardviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindFirst(message : ChatMessage){
            println("bindfirst")
            binding.message = message
        }

        fun bind(message : ChatMessage, message2 : ChatMessage){
            binding.message = message
            //Item sectioning would be implemented differently on a multi chat app

            var hourToMillis = 60 * 60 * 1000
            var millisBetweenMessages = message.date.time - message2.date.time

            if(millisBetweenMessages > hourToMillis ){
                binding.itemSectioning.visibility = View.VISIBLE
            }else{
                binding.itemSectioning.visibility = View.GONE
            }


            //set random colour to layout
        }


    }

}