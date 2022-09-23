package com.example.broadcast_receivers_example

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //Dynamic Broadcast Receiver
    private lateinit var dynamicReceiver: DynamicAirplaneModeChangedReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dynamicReceiver = DynamicAirplaneModeChangedReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(dynamicReceiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(dynamicReceiver)
    }
}