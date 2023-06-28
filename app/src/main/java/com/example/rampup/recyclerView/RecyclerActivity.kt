package com.example.rampup.recyclerView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rampup.R

class RecyclerActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var contactEditText: EditText
    lateinit var addButton: Button
    lateinit var recycleId: RecyclerView
     var detailsList:ArrayList<UserDetails> = ArrayList()

    lateinit var userAdapter:UserDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        nameEditText = findViewById(R.id.name_Details)
        contactEditText = findViewById(R.id.contact_Details)
        addButton = findViewById(R.id.submit_button)
        recycleId=findViewById(R.id.recycle_id)
        addButton.setOnClickListener{
            detailsList.add(UserDetails( nameEditText.text.toString(),contactEditText.text.toString().toInt())
            )

            val sharedPreferences=getSharedPreferences("userDetailsPreference",Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            val name=nameEditText.text.toString()
            val number=contactEditText.text.toString().toInt()
            val details= arrayListOf<UserDetails>()
            //store the list
        //key ame DETAILS
            editor.putString(name,"name" )
            editor.putInt("Number", number)
            editor.apply()
            Toast.makeText(this@RecyclerActivity, "Data added to SharedPreferences", Toast.LENGTH_SHORT).show()
            nameEditText.text.clear()
            contactEditText.text.clear()
            userAdapter = UserDetailsAdapter(detailsList) // Set the userAdapter again
            recycleId.adapter = userAdapter
            userAdapter.notifyDataSetChanged()
        }
      /*  userAdapter=UserDetailsAdapter(detailsList)
        //data to be displayed in the RecyclerView.
        recycleId.adapter = userAdapter*/
        //items in the RecyclerView are displayed.vertically in linearlayout
        recycleId.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        //get the list form shard pref
//        detailsList.clear()
        //detailstlit .addAdd(shared pref)
        //key Name = DETAILS
    }
}