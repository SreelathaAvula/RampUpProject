package com.example.rampup.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.adapters.ViewBindingAdapter.setClickListener
import com.example.rampup.R
import com.example.rampup.databinding.ActivityServiceBinding
import com.example.rampup.databinding.ActivitySharedBinding

class ServiceActivity : AppCompatActivity(){
    val TAG=ServiceActivity::class.java.simpleName
     lateinit var binding: ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.StartServiceButton.setOnClickListener{
            redirectToStartServicePge()
        }
        binding.boundServiceButton.setOnClickListener{
            redirectToBoundService()

        }



    }

    private fun redirectToStartServicePge() {
        startActivity(Intent(this@ServiceActivity,StartedServiceActivity::class.java))
    }

    private fun redirectToBoundService() {
        startActivity(Intent(this@ServiceActivity,BoundServiceActivity::class.java))

    }


}