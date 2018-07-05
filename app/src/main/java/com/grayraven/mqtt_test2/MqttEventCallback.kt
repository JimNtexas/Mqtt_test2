package com.grayraven.mqtt_test2

import android.annotation.SuppressLint
import android.util.Log
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

class MqttEventCallback : MqttCallback {

    internal val TAG = "MqttEventCb"

    override fun connectionLost(arg0: Throwable) {
        Log.d(TAG, "connection lost")

    }

    override fun deliveryComplete(arg0: IMqttDeliveryToken) {

        Log.i(TAG, "deliveryComplete")
    }

    @SuppressLint("NewApi")
    @Throws(Exception::class)
    override fun messageArrived(topic: String, msg: MqttMessage) {
          Log.i(TAG, "Message arrived from topic" + topic);

    }
}
