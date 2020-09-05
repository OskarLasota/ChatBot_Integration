package com.frezzcoding.muzmatch_oskarlasota.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.frezzcoding.muzmatch_oskarlasota.R
import com.frezzcoding.muzmatch_oskarlasota.contracts.ChatContract
import com.frezzcoding.muzmatch_oskarlasota.databinding.ActivityMainBinding
import com.frezzcoding.muzmatch_oskarlasota.models.ChatMessage
import com.frezzcoding.muzmatch_oskarlasota.view.adapters.ChatViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ChatContract.View {

    @Inject lateinit var presenter: ChatContract.Presenter
    private lateinit var adapterChat : ChatViewAdapter
    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AndroidInjection.inject(this)

        setListeners()
    }


    private fun setListeners(){
        findViewById<FloatingActionButton>(R.id.btn_randommessage)?.setOnClickListener {
            presenter.getRandomMessage()
        }
        binding.btnSendmessage.setOnClickListener {
            if(binding.etMessage.text.toString().isNotEmpty()) {
                presenter.sendMessage(binding.etMessage.text.toString())
                binding.etMessage.text?.clear()
            }
        }
    }

    override fun initView(list : List<ChatMessage>) {
        //initialize the view
        adapterChat = ChatViewAdapter(list)
        adapterChat.setHasStableIds(true)
        binding.recyclerMessanger.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerMessanger.adapter = adapterChat

        if(list.isNotEmpty()) {
            binding.recyclerMessanger.scrollToPosition(list.size - 1)
        }
    }

    override fun updateScreenNewMessage(list : List<ChatMessage>) {
        //refresh the recycler view
        //animate this
        if(list.isNotEmpty()) {
            adapterChat.notifyDataSetChanged()
            binding.recyclerMessanger.scrollToPosition(list.size - 1)
        }
    }

}