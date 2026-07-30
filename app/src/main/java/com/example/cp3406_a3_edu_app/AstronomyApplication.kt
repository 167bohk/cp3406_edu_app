package com.example.cp3406_a3_edu_app

import android.app.Application
import com.example.cp3406_a3_edu_app.data.AppContainer
import com.example.cp3406_a3_edu_app.data.DefaultAppContainer

class AstronomyApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
