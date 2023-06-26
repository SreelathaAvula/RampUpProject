package com.example.rampup.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.rampup.R

class IntentActivity : AppCompatActivity() {
    lateinit var searchButton:Button
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        searchButton=findViewById(R.id.clickButton)
        editText=findViewById(R.id.editText)
        searchButton.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(editText.text.toString())))
        }
    }
}