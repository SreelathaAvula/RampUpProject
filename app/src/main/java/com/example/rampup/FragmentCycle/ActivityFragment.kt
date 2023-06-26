package com.example.rampup.FragmentCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.rampup.R

class ActivityFragment : AppCompatActivity() {
    lateinit var firstButton: Button
    lateinit var secondButton: Button
    lateinit var layout: LinearLayoutCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_item)
        firstButton = findViewById(R.id.button1)
        secondButton = findViewById(R.id.button2)
        layout = findViewById(R.id.layoutlinear)
        firstButton.setOnClickListener {
            var fragment = FirstFragment()
            supportFragmentManager.beginTransaction().replace(R.id.layoutlinear, fragment).commit()
        }
        secondButton.setOnClickListener {
            var fragment = SecondFragment()
            supportFragmentManager.beginTransaction().replace(R.id.layoutlinear, fragment).commit()
            /*replaceFragment(FirstFragment())*/
        }
        /*  private fun replaceFragment(fragment: FirstFragment) {
            supportFragmentManager.beginTransaction().replace(R.id.layoutlinear, fragment).commit()
        }*/
    }
}