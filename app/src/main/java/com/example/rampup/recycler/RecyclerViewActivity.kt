package com.example.rampup.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rampup.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    lateinit var nameList: ArrayList<UserData>
    lateinit var detailsAdapter:UserDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameList= arrayListOf()
        detailsAdapter=UserDataAdapter(nameList)
        binding.displayId.adapter = detailsAdapter
        binding.displayId.layoutManager = LinearLayoutManager(this)
        binding.submitButton.setOnClickListener {
            nameList.add(
                UserData(
                    binding.nameDetails.text.toString(),
                    binding.contactDetails.text.toString().toLong()
                ))

            binding.displayId.adapter?.notifyDataSetChanged()
            binding.nameDetails.text?.clear()
            binding.contactDetails.text?.clear()

        }
    }
}