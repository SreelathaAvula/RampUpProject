package com.example.rampup.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rampup.R
import com.example.rampup.databinding.ActivityStartedServiceBinding

class StartedServiceActivity : AppCompatActivity() {
    lateinit var binding:ActivityStartedServiceBinding
    private val TAG=StartedServiceActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartedServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var isServiceRunning=false

        binding.startButton.setOnClickListener {
            if(!isServiceRunning){
             startService(Intent(this@StartedServiceActivity,MusicService::class.java))
                isServiceRunning=true
                Log.i(TAG, "onCreate:  startService()")

            }
        }
        binding.stopButton.setOnClickListener {
          stopService(Intent(this,MusicService::class.java))
            isServiceRunning=false
        }
    }
}