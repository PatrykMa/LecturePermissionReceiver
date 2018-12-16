package com.example.patryk.lecturepermissionreceiver

import android.Manifest
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var system:SystemReceiver
    lateinit var custom:CustomReceiver
    lateinit var without:WithoutReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        system=SystemReceiver()
        custom=CustomReceiver()
        without=WithoutReceiver()
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.SEND_SMS),1)
        if (ContextCompat.checkSelfPermission(this,"com.example.PAM_CUSTOM")!= PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,arrayOf("com.example.PAM_CUSTOM"),2)

        registerReceiver(system, IntentFilter("com.example.PAM_SYSTEM"))
        registerReceiver(custom, IntentFilter("com.example.PAM_CUSTOM"))
        registerReceiver(without, IntentFilter("com.example.PAM_NONE"))
    }

    override fun onDestroy() {
        unregisterReceiver(system)
        unregisterReceiver(custom)
        unregisterReceiver(without)
        super.onDestroy()
    }

}
