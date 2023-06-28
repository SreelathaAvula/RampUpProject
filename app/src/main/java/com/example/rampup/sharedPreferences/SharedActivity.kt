package com.example.rampup.sharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rampup.R
import com.example.rampup.databinding.ActivitySharedBinding

class SharedActivity : AppCompatActivity() {
   private lateinit var binding:ActivitySharedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getSharedPreferences("my_data", MODE_PRIVATE)
        binding.nameText.setText(editor.getString("email",null))
        binding.NumText.setText(editor.getString("age",null))
        binding.sendButton.setOnClickListener {
            val editor=getSharedPreferences("my_data", MODE_PRIVATE).edit()
            editor.putString("email",binding.nameText.text.toString())
            editor.putString("age",binding.NumText.text.toString())
            editor.apply()
            startActivity(Intent(this@SharedActivity,SharedSecondActivity::class.java))
        }
    }
}