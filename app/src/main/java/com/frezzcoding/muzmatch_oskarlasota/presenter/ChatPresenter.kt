package com.frezzcoding.muzmatch_oskarlasota.presenter

import com.frezzcoding.muzmatch_oskarlasota.contracts.ChatContract
import com.frezzcoding.muzmatch_oskarlasota.models.ChatMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class ChatPresenter @Inject constructor(private val view: ChatContract.View, private val model : ChatContract.Model): ChatContract.Presenter {

    init {
        getAllMessages()
    }

    override fun getAllMessages() {
        CoroutineScope(Dispatchers.Main).launch {
            view.initView(model.getStoredMessages())
        }
    }

    override fun sendMessage(message : String) {
        //send a asynchronous message to the database
        var chatMessage = ChatMessage()
        chatMessage.user_id = 1
        chatMessage.message = message
        chatMessage.date = Date()

        CoroutineScope(Dispatchers.Main).launch {
            model.insertMessage(chatMessage)
            view.updateScreenNewMessage(model.getStoredMessages())
        }
    }

    override fun getRandomMessage() {
        //get a random string from bot
        var message = (0..10000).random().toString()
        var chatMessage = ChatMessage()
        chatMessage.user_id = 0
        chatMessage.message = message
        chatMessage.date = Date()

        CoroutineScope(Dispatchers.Main).launch {
            model.insertMessage(chatMessage)
            view.updateScreenNewMessage(model.getStoredMessages())
        }
    }


}