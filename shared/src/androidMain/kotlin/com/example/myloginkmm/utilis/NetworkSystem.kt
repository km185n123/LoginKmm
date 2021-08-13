package com.example.myloginkmm.utilis

import android.content.Context
import android.net.ConnectivityManager
import com.example.myloginkmm.di.InjectorCommon

actual class ContextArgs(
    var mContext: Context
)

actual fun isNetworkAvailable(): Boolean{
    val connectivityManager = InjectorCommon.mContextArgs?.mContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting

}