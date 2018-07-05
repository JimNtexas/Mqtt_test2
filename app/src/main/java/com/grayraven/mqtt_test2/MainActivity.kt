package com.grayraven.mqtt_test2

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttException



class MainActivity : AppCompatActivity() {

    val TAG = "MAIN_ACTIVITY"
    internal val broker = "tcp://10.211.1.127"
    //internal var password = "monkey123"
   // internal var username = "pi"
    internal val topic = "car_command" as String
    val clientId = MqttAsyncClient.generateClientId()
    val context: Context =Mqtt2app.getAppContext()
    val client = MqttAndroidClient(context, broker,
            clientId)

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
        if(client == null) {
            Log.d(TAG, "Client was null, could not connect!")
            return
        }
        try {
            client.subscribe(topic,1);
            val token = client.connect()
            token.actionCallback = object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    // We are connected
                    Log.d(TAG, "onSuccess")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d(TAG, "onFailure")

                }
            }
        } catch (e: MqttException) {
            e.printStackTrace()
        }

    }


}
