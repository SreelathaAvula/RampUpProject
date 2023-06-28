package com.example.rampup.sharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rampup.R
import com.example.rampup.databinding.ActivitySharedBinding
import com.google.gson.Gson

class SharedActivity : AppCompatActivity() {
   private lateinit var binding:ActivitySharedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getSharedPreferences("my_data", MODE_PRIVATE)
        binding.nameText.setText(editor.getString("email",null))
       val age= editor.getString("age",null)

        binding.sendButton.setOnClickListener {

            val editor=getSharedPreferences("my_data", MODE_PRIVATE).edit()
            editor.putString("email",binding.nameText.text.toString())
            editor.putInt("age",age?.toInt() ?: 0)

            editor.apply()
            startActivity(Intent(this@SharedActivity,SharedSecondActivity::class.java))
        }
    }
}