package com.example.myapplication.ui.repository

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.R
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*

class MqttService : Service() {

    private lateinit var client: MqttAndroidClient
    private val serverUri = "tcp://YOUR_MQTT_BROKER_ADDRESS:1883"
    private val clientId = "AndroidClient"
    private val topic = "topico/alertas"

    override fun onCreate() {
        super.onCreate()
        client = MqttAndroidClient(applicationContext, serverUri, clientId)
        connectAndSubscribe()
    }

    private fun connectAndSubscribe() {
        try {
            val options = MqttConnectOptions().apply {
                isCleanSession = true
            }

            client.connect(options, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    client.setCallback(object : MqttCallback {
                        override fun connectionLost(cause: Throwable?) {}

                        override fun messageArrived(topic: String?, message: MqttMessage?) {
                            message?.let {
                                val alerta = String(it.payload)
                                sendNotification(alerta)
                            }
                        }

                        override fun deliveryComplete(token: IMqttDeliveryToken?) {}
                    })

                    try {
                        client.subscribe(topic, 1)
                    } catch (e: MqttException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    // Falha na conexão
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDestroy() {
        try {
            client.disconnect()
        } catch (e: MqttException) {
            e.printStackTrace()
        }
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun sendNotification(message: String) {
        val channelId = "MqttAlertsChannel"
        val channelName = "Alertas MQTT"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.mep_logo) // Substitua pelo ícone da sua notificação
            .setContentTitle("Alerta MQTT")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(0, notificationBuilder.build())
    }
}
