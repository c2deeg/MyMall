package com.app.mymall.Utils

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

open class MyApplication : MultiDexApplication()  {
    override fun onCreate() {
        super.onCreate()
        WebServices().create()
        MultiDex.install(applicationContext)
//        FacebookSdk.sdkInitialize(getApplicationContext());
    }

}