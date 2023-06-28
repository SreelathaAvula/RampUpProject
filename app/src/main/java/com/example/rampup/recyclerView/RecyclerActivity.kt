package com.example.rampup.recyclerView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rampup.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RecyclerActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var contactEditText: EditText
    lateinit var addButton: Button
    lateinit var display: TextView
   // var detailsList: ArrayList<UserDetails> = ArrayList()
    lateinit var details: ArrayList<UserDetails>


    //lateinit var userAdapter: UserDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        nameEditText = findViewById(R.id.name_Details)
        contactEditText = findViewById(R.id.contact_Details)
        addButton = findViewById(R.id.submit_button)
        display = findViewById(R.id.display_id)

        //recycleId = findViewById(R.id.recycle_id)

        loadData()
        addButton.setOnClickListener {
            saveData(nameEditText.text.toString(),contactEditText.text.toString())
            Log.d("RecyclerActivity", " oncreate on recyclerActivity: ")

        }
    }

    private fun loadData() {
        Log.d("RecyclerActivity", " loadData on recyclerActivity: ")

        val sharedpref=getSharedPreferences("RECYCLEDATA", MODE_PRIVATE)
        val gson=Gson()

        val json:String?=sharedpref.getString("user_data",null)

        if (json != null) {
            val type: Type = object : TypeToken<ArrayList<UserDetails>>() {}.type
            details = gson.fromJson(json, type)
        } else {
            details = ArrayList()
        }
        if (details == null) {
            details = ArrayList()
        }
        else{
            val stringBuilder = StringBuilder()

            for (i in details.indices) {
                stringBuilder.append(details[i].name)
                stringBuilder.append(" - ")
                stringBuilder.append(details[i].contact)
                stringBuilder.append("\n") // Add a line break between each name
            }
            display.text = stringBuilder.toString() //
            /*userAdapter = UserDetailsAdapter(details) // Set the userAdapter again
            recycleId.adapter = userAdapter
            recycleId.adapter?.notifyDataSetChanged()*/
        }
    }
    private fun saveData(name: String, contact: String) {
        val editor=getSharedPreferences("RECYCLEDATA", MODE_PRIVATE).edit()
        //gson arraylist into string expression
        val gson=Gson()
        details.add(UserDetails(nameEditText.text.toString(),contactEditText.text.toString().toInt()))
        var json:String=gson.toJson(details)
        editor.putString("user_data",json)
        editor.apply()
        loadData()
       /* userAdapter = UserDetailsAdapter(details) // Set the userAdapter again
        recycleId.adapter = userAdapter
        userAdapter.notifyDataSetChanged()*/
    }

}
