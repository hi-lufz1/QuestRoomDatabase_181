package com.example.roomlocaldb

import android.app.Application
import com.example.roomlocaldb.dependeciesinjection.ContainerApp

class KrsApp : Application() {
    //Fungsinya untuk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp


    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}