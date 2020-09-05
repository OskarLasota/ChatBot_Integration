package com.frezzcoding.muzmatch_oskarlasota.di.components

import com.frezzcoding.muzmatch_oskarlasota.App
import com.frezzcoding.muzmatch_oskarlasota.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
     fun inject(application: App)

}