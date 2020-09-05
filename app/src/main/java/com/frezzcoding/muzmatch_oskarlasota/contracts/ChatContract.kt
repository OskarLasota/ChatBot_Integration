package com.frezzcoding.muzmatch_oskarlasota.contracts

import com.frezzcoding.muzmatch_oskarlasota.models.ChatMessage

interface ChatContract {

    interface View {
        fun initView(list : List<ChatMessage>)
        fun updateScreenNewMessage(list : List<ChatMessage>)
    }

    interface Presenter {
        fun getAllMessages()
        fun getRandomMessage()
        fun sendMessage(message : String)
    }

    interface Model {
        fun getStoredMessages() : List<ChatMessage>
        fun insertMessage(message : ChatMessage)
    }

}