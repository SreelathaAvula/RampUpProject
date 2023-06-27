package com.example.rampup.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.rampup.R

class SecondActivity : AppCompatActivity() {
    lateinit var textReceive:TextView
    lateinit var phoneReceive:TextView
    lateinit var scoreReceive:TextView
    lateinit var booleanReceive:TextView
    lateinit var listReceiver:TextView
    lateinit var objReceiver:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textReceive=findViewById(R.id.receiverText)
        phoneReceive=findViewById(R.id.receiverPhone)
        scoreReceive=findViewById(R.id.receiverScore)
        booleanReceive=findViewById(R.id.receiverBoolean)
        listReceiver=findViewById(R.id.receiverList)
        objReceiver=findViewById(R.id.receiverObj)


        textReceive.text=  intent.getStringExtra("msg_key")
        phoneReceive.text= intent.getIntExtra("phone_key",0).toString()
        scoreReceive.text=intent.getFloatExtra("score_key",0f).toString()
        booleanReceive.text=intent.getBooleanExtra("company_msg",false).toString()
        listReceiver.text=intent.getSerializableExtra("list_msg").toString()

     /*
       var data= intent.getSerializableExtra("objdata") as UserData
        objReceiver.text=data.name
        objReceiver.append(data.age.toString())*/
        objReceiver.text=intent.getParcelableExtra<Details>("objdata1").toString()
        objReceiver.append(intent.getParcelableExtra<Details>("objdata2").toString())
    }
}