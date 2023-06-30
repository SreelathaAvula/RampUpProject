package com.example.rampup.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rampup.R

class UserDataAdapter(val details: ArrayList<UserData>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<UserDataAdapter.userDetailViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userDetailViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.card_view, parent, false)
        return userDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return details.size
    }

    override fun onBindViewHolder(holder: userDetailViewHolder, position: Int) {
        val userName = details[position]
        holder.name.text = userName.name
        val userNumber: UserData= details[position]
        holder.number.text = userNumber.contact.toString()
        holder.delete.setOnClickListener {
            if(it !==null)
                deleteEvent(position)
        }
    }

    private fun deleteEvent(position: Int) {
        details.remove(details.get(position))
        notifyDataSetChanged()
    }

    class userDetailViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameview)
        val number: TextView = itemView.findViewById(R.id.numberView)
        val delete: Button = itemView.findViewById(R.id.deleteButton)
    }

}