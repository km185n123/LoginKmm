package com.example.myloginkmm.di

import com.example.myloginkmm.utilis.ContextArgs
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object InjectorCommon {

    var mContextArgs: ContextArgs? = null

    fun provideContextArgs(contextArgs: ContextArgs): ContextArgs? {
        mContextArgs = contextArgs
        return mContextArgs
    }


}