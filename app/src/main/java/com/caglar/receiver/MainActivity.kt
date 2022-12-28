package com.caglar.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val ifilter = IntentFilter()
    var receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val updatedVariable = intent?.getStringExtra("ts")
            println("in receiver")
            if (updatedVariable != null) {
                Log.d("MainActivity", "received in MainActivity: $updatedVariable")
            }
            println( )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ifilter.addAction("TestService")

        try {
            startService(Intent(this,TestService::class.java))
        }catch (ex: Exception) {
            ex.printStackTrace()
        }

        registerReceiver(receiver,ifilter)

    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}