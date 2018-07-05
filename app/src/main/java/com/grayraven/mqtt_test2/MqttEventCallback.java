package com.grayraven.mqtt_test2;

import android.annotation.SuppressLint;
import android.util.Log;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;

public class MqttEventCallback implements MqttCallback {

    final String TAG = "MqttEventCb";

    @Override
    public void connectionLost(Throwable arg0) {
        Log.d(TAG, "connection lost");

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken arg0) {

        Log.i(TAG, "deliveryComplete" );
    }

    @Override
    @SuppressLint("NewApi")
    public void messageArrived(String topic, final MqttMessage msg) throws Exception {
        //  Log.i(TAG, "Message arrived from topic" + topic);

    }
}