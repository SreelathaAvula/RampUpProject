package com.example.rampup.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*


class BoundService : Service() {
    val binder=MyBinder()
    private val random = Random()
private val TAG=BoundService::class.java.simpleName
    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind: ")
        return binder
    }
    inner class MyBinder: Binder(){
        fun getService():BoundService{
            return this@BoundService
        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
    fun generateRandomNumber(): Int {
        return random.nextInt(100)
    }
}