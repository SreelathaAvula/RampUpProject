package com.example.rampup.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MusicService : Service() {
    private lateinit var audioplayer:MediaPlayer

private var TAG=MusicService::class.java.simpleName
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand: ")

        audioplayer= MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        audioplayer.setLooping(true)
        audioplayer.start()
        //return super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }
    override fun onBind(intent: Intent): IBinder? {
        Log.i(TAG, "onBind: ")
        return null
    }
    override fun onCreate() {
        Log.i(TAG, "onCreate: ")
        super.onCreate()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i(TAG, "onUnbind: ")
        return super.onUnbind(intent)

    }

    override fun onRebind(intent: Intent?) {
        Log.i(TAG, "onRebind: ")
        super.onRebind(intent)
    }
    override fun onDestroy() {
        Log.i(TAG, "onDestroy: ")
        audioplayer.stop()
        super.onDestroy()
    }
}
