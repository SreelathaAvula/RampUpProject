package com.example.rampup.sharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.rampup.R
import com.example.rampup.databinding.ActivitySharedBinding
import com.example.rampup.databinding.ActivitySharedSecondBinding

class SharedSecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySharedSecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor=getSharedPreferences("my_data", MODE_PRIVATE)
        binding.displayPrevious.setText("mail is ${editor.getString("email",null)}   password is ${editor.getString("age",null)}")
    }
}