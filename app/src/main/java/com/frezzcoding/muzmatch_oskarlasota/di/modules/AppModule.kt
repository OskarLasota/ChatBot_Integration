package com.frezzcoding.muzmatch_oskarlasota.di.modules

import com.frezzcoding.muzmatch_oskarlasota.contracts.ChatContract
import com.frezzcoding.muzmatch_oskarlasota.view.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class AppModule {

    @ContributesAndroidInjector(modules = [ChatModule::class])
    abstract fun contributeMainActivity() : MainActivity

    @Binds
    abstract fun bindMainView(mainActivity: MainActivity) : ChatContract.View



}