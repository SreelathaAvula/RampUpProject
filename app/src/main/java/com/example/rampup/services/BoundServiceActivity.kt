package com.example.rampup.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.example.rampup.R
import com.example.rampup.databinding.ActivityBoundServiceBinding
import com.google.firebase.firestore.core.Bound
import com.google.firebase.firestore.core.View

class BoundServiceActivity : AppCompatActivity() {
    lateinit var binding: ActivityBoundServiceBinding
     var boundService:BoundService?=null
    var isBound=false
    private val TAG=BoundServiceActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoundServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.start.setOnClickListener {
            generateRandom()
            Log.d(TAG, "onCreate:  clicking start button")
        }
        Log.d(TAG, "onCreate: ")
    }
    //service connect or duisconnect we use service object
    private val connection=object:ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            // cast the service object to the type BoundService.MyBinder.
            val binder=service as? BoundService.MyBinder
//            boundService = binder
            boundService = binder?.getService()
//            boundService?.binder?.getService()
            isBound=true
            Log.d(TAG, "onServiceConnected: ")
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            boundService=null
            isBound=false
            Log.d(TAG, "onServiceDisconnected: ")
        }
    }
    override fun onStart() {
        super.onStart()
        val intent=Intent(this@BoundServiceActivity, BoundService::class.java)
        //auto maticaklly create service as long as service bind to it
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        Log.d(TAG, "onStart: ")
        }
    override fun onStop() {
        super.onStop()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
        Log.d(TAG, "onStop: ")
    }
    private fun generateRandom() {
        if (isBound) {
            val randomNumber = boundService?.generateRandomNumber()
            binding.diaplay.text=randomNumber.toString()
            Log.d(TAG, "generateRandom: ")

        }
    }
}



