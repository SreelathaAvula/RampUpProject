package com.example.rampup.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rampup.R

class IntentActivity : AppCompatActivity() {
    lateinit var searchButton: Button
    lateinit var editText: EditText
    lateinit var expliciIntent: Button

    //explicit
    lateinit var sendText: EditText
    lateinit var sendButton: Button
    lateinit var phoneEditText:EditText
    lateinit var scoreEditText:EditText
    lateinit var booleanText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        searchButton = findViewById(R.id.clickButton)
        editText = findViewById(R.id.editText)
        searchButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(editText.text.toString())))
        }
        expliciIntent = findViewById(R.id.explicitButton)
        expliciIntent.setOnClickListener {
            reDirectToSecondActivity()
        }

        //explicit

        sendText = findViewById(R.id.explicitEditText)
        phoneEditText = findViewById(R.id.phoneText)
        scoreEditText = findViewById(R.id.scoreText)
        booleanText=findViewById(R.id.booleanText)

        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            var intent: Intent = Intent(this@IntentActivity, SecondActivity::class.java)
            intent.putExtra("msg_key", sendText.text.toString())
            intent.putExtra("score_key",scoreEditText.text.toString().toFloat())
            intent.putExtra("phone_key",phoneEditText.text.toString().toInt())
            val booleanType=booleanText.text.toString().equals("Appscrip")
            intent.putExtra("company_msg",booleanType)

            var list:ArrayList<String> = arrayListOf()
            list.add("sreelatha")
            list.add("gunasekhar")
            list.add("sreekanth")
            intent.putExtra("list_msg",list)

            intent.putExtra("objdata",UserData("sreelatha",24))


            intent.putExtra("objdata1",Details("roja",34))
            intent.putExtra("objdata2",Details("megha",23))


            startActivity(intent)
        }
    }
    private fun reDirectToSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}