package com.frezzcoding.muzmatch_oskarlasota

import android.app.Activity
import android.app.Application
import com.frezzcoding.muzmatch_oskarlasota.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var injector : DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = injector

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        var configuration : RealmConfiguration = RealmConfiguration.Builder().name("RealmData.realm").build()
        Realm.setDefaultConfiguration(configuration)

        DaggerAppComponent.builder().build().inject(this)
    }


}