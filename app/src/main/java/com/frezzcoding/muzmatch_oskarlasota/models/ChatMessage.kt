package com.frezzcoding.muzmatch_oskarlasota.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ChatMessage : RealmObject() {

    @PrimaryKey
    var message_id = 0
    var user_id = 0
    var date : Date = Date()
    var message : String? = null

    fun getFormattedDate() : String {
        return date.toString().substring(0,16)
    }


}