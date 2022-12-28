package com.caglar.receiver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TestService : Service() {
    init {
        Log.d("QRService","Service is running...")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(init : Intent, flag : Int, startId: Int):Int{
        Log.d("QRService","onStartCommand...")
        Thread(Runnable {
            while (true) {
                Log.d("QRService","running function in service...")

                val intent = Intent("TestService")
                intent.putExtra("ts","test service intent extra")
                sendBroadcast(intent)
                Thread.sleep(2000)
            }
        }).start()
        return START_STICKY
    }
}