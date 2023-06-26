package com.example.rampup.activitylifecyclenobinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.rampup.MainActivity
import com.example.rampup.R

class LifeCycle : AppCompatActivity(){
    lateinit var  button:Button
    var TAG = "LifeCycle";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "onCreate() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onCreate: ")

        setContentView(R.layout.activity_life_cycle_no_binding)
         button=findViewById(R.id.btnLifecycle)
         button.setOnClickListener{
             redirectToHomePage()
         }
    }
    private fun redirectToHomePage() {
        startActivity(Intent(this,MainActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onPause: ")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onRestart: ")
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy() called", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onDestroy: ")
    }
}