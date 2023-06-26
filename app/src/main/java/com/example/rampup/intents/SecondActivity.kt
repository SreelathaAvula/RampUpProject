package com.example.rampup.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rampup.R

class SecondActivity : AppCompatActivity() {
    lateinit var textReceive:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textReceive=findViewById(R.id.receiverText)
        textReceive.text=  intent.getStringExtra("msg_key")

    }
}