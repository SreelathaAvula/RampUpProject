package com.example.rampup.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneModeChangeReceiver:BroadcastReceiver(){
    private val TAG=AirplaneModeChangeReceiver::class.java.simpleName
    override fun onReceive(context: Context?, intent: Intent?) {
        /**
         * getBooleanExtra() method is a function provided by the Intent class in Android.
         *
         *
         *
         *
         */

        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirplaneModeEnabled){
            Toast.makeText(context,"airplaneMode enabled....",Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onReceive:  the airplane moe enabled")
        }
        else{
            Toast.makeText(context,"Aroplanemode disabled",Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onReceive:  the airplane moe disabled")
        }

        Log.d(TAG, "onReceive: ")
    }
}