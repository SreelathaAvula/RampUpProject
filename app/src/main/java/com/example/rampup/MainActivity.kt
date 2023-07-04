package com.example.rampup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.rampup.FragmentCycle.ActivityFragment
import com.example.rampup.activitylifecycle.ActivityLifeCycle
import com.example.rampup.activitylifecyclenobinding.LifeCycle
import com.example.rampup.broadcastreceiver.BroadcastReceiverActivity
import com.example.rampup.databinding.ActivityMainBinding
import com.example.rampup.intents.IntentActivity
import com.example.rampup.recycler.RecyclerViewActivity
import com.example.rampup.recyclerView.RecyclerActivity
import com.example.rampup.services.ServiceActivity
import com.example.rampup.sharedPreferences.SharedActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
companion object {
    //used to obtain the simple name of the MainActivity class dynamically at runtime.
    private  val TAG = MainActivity::class.java.simpleName
}
private var binding: ActivityMainBinding? = null

override fun onCreate(savedInstanceState: Bundle?) {
    WindowCompat.setDecorFitsSystemWindows(window, false)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding?.root)
    setClickListener()
}/**
 * Your comments
 */
private fun setClickListener() {
    binding?.apply {
        //MainActivity class itself implements the OnClickListener interface and onclick() called in mainActivity class only
        btnActivityLifeCycle.setOnClickListener(this@MainActivity)
        btnFragmentLifeCycle.setOnClickListener(this@MainActivity)
        btnActivityLifeCycleNoBind.setOnClickListener(this@MainActivity)
        intentButton.setOnClickListener(this@MainActivity)
        recyclerButton.setOnClickListener(this@MainActivity)
        sharedButton.setOnClickListener(this@MainActivity)
        serviceButton.setOnClickListener(this@MainActivity)
        recyclerviewButton.setOnClickListener(this@MainActivity)
        broadcastButton.setOnClickListener ( this@MainActivity )
        Log.d(TAG, "setClickListener of servicw in main activity: ")
    }
}
override fun onClick(view: View?) {
    when(view?.id)
    {
        R.id.btnActivityLifeCycle -> redirectToActivityLifCycle()
        R.id.btnActivityLifeCycleNoBind->redirectToLifCycle()
        R.id.btnFragmentLifeCycle->redirectToFragmentPge()
        R.id.intentButton->redirectToIntentPage()
        R.id.recyclerButton->redirectToRecyclerViewPage()
        R.id.sharedButton->redirectToSharedActivityPage()
        R.id.serviceButton->redirectToServicePage()
        R.id.recyclerviewButton->redirectToRecyclerView()
        R.id.broadcastButton->redirectToBroadcatActivityPage()
        else -> noClickListenerAttach()
    }
}



    private fun redirectToActivityLifCycle() {
    startActivity(Intent(this, ActivityLifeCycle::class.java))
}
    private fun redirectToFragmentPge() {
        startActivity(Intent(this@MainActivity,ActivityFragment ::class.java))
    }
    private fun redirectToLifCycle() {
        startActivity(Intent(this,LifeCycle::class.java))
    }
    private fun redirectToIntentPage() {
        startActivity(Intent(this@MainActivity,IntentActivity::class.java))
        Toast.makeText(this,"redirect to Intent Activity",Toast.LENGTH_SHORT).show()
    }/**
 *     Runs the specified action on the UI thread. If the current thread is the UI thread,

 */
    private fun redirectToRecyclerViewPage() {
        startActivity(Intent(this@MainActivity,RecyclerActivity::class.java)
        )
        Toast.makeText(this,"redirect to Recycler Activity",Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", " recycler button clicked redirectToRecyclerViewPage: ")

    }
    private fun redirectToSharedActivityPage() {
        startActivity(Intent(this@MainActivity,SharedActivity::class.java))
    }
    private fun redirectToServicePage() {
        startActivity(Intent(this@MainActivity,ServiceActivity::class.java))
        Log.d(TAG, "redirectToServicePage: ")
    }
    private fun redirectToRecyclerView() {
startActivity(Intent(this@MainActivity,RecyclerViewActivity::class.java))
    }

    private fun redirectToBroadcatActivityPage() {
        startActivity(Intent(this@MainActivity,BroadcastReceiverActivity::class.java))
    }



    private fun noClickListenerAttach() {
    runOnUiThread {
        Toast.makeText(this, "No click listener attached", Toast.LENGTH_SHORT).show()
    }
}
   /* override fun onBackPressed() {
        super.onBackPressed()
    }*/
}