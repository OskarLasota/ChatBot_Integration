package com.frezzcoding.muzmatch_oskarlasota.models

import com.frezzcoding.muzmatch_oskarlasota.contracts.ChatContract
import io.realm.Realm
import javax.inject.Inject

class ChatStateModel @Inject constructor(private val realm : Realm) : ChatContract.Model {


    override fun getStoredMessages() : List<ChatMessage>{
        realm.beginTransaction()
        val list = realm.where(ChatMessage::class.java).findAll()

        realm.commitTransaction()
        return list
    }

    override fun insertMessage(message : ChatMessage) {
        //this is my first time using realm so this implementation doesn't look too clean
        realm.beginTransaction()
        //find last highest id
        var maxId = realm.where(ChatMessage::class.java).max("message_id")
        var newId = maxId?.let {
            maxId.toInt()+1}

        val newMessage = realm.createObject(ChatMessage::class.java, newId ?: 0)
        newMessage.message = message.message
        newMessage.user_id = message.user_id
        newMessage.date = message.date

        realm.commitTransaction()
    }

}