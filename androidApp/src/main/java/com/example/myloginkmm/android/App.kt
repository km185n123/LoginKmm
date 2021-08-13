package com.example.myloginkmm.android

import androidx.multidex.MultiDexApplication
import com.example.myloginkmm.di.InjectorCommon
import com.example.myloginkmm.utilis.ContextArgs


open class App : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
        InjectorCommon.provideContextArgs(ContextArgs(this))
    }
}