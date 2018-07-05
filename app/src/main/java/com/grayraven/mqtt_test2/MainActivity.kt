package com.grayraven.mqtt_test2

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence


class MainActivity : AppCompatActivity() {

    val TAG = "MAIN_ACTIVITY"
    internal val broker = "tcp://10.211.1.127"
    //internal var password = "monkey123"
   // internal var username = "pi"
    internal val topic = "car_command" as String
    val clientId = MqttAsyncClient.generateClientId()
    val context: Context =Mqtt2app.getAppContext()
    val persistence = MemoryPersistence()
    val client = MqttClient(broker, clientId, persistence)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDoIt = findViewById<Button>(R.id.do_something)
        val clientId = MqttAsyncClient.generateClientId()

        btnDoIt.setOnClickListener{
            Log.d(TAG, "Button clicked")
            mqttConnect()
            Log.d(TAG, "client connected: " + client.isConnected())

        }
    }

    fun mqttConnect() {

        try {
            client.setCallback(MqttEventCallback())
           // val options =  MqttConnectOptions()
            client.setCallback(MqttEventCallback())
            client.connect()
            client.subscribe("car_connect",1);
        } catch (e: MqttException) {
            e.printStackTrace()
        }

    }


}
