package com.teo.dagger2sample

import android.app.Application
import com.teo.dagger2sample.dagger.AppComponent
import com.teo.dagger2sample.dagger.modules.AppModule
import com.teo.dagger2sample.dagger.DaggerAppComponent

class Dagger2Application : Application() {

    lateinit var appComponent: AppComponent

    private fun initDagger(app: Dagger2Application): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

    override fun onCreate() {
        super.onCreate()
        // init dagger...
        appComponent = initDagger(this)

    }

}