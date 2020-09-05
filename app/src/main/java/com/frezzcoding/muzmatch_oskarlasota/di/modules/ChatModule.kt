package com.frezzcoding.muzmatch_oskarlasota.di.modules

import com.frezzcoding.muzmatch_oskarlasota.contracts.ChatContract
import com.frezzcoding.muzmatch_oskarlasota.models.ChatStateModel
import com.frezzcoding.muzmatch_oskarlasota.presenter.ChatPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module(includes = [ChatModule.ChatBindings::class])
class ChatModule {

    @Provides
    fun provideRealm() : Realm = Realm.getDefaultInstance()

    @Module
    interface ChatBindings {
        @Binds
        fun bindChatPresenter(chatPresenter : ChatPresenter) : ChatContract.Presenter

        @Binds
        fun bindModelState(chatStateModel: ChatStateModel) : ChatContract.Model
    }


}