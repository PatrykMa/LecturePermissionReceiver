package com.example.patryk.lecturepermissionreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SystemReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"System",Toast.LENGTH_SHORT).show()
    }
}

class CustomReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"Custom",Toast.LENGTH_SHORT).show()
    }
}

class WithoutReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"NONE",Toast.LENGTH_SHORT).show()
    }
}