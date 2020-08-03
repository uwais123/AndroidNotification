package com.masuwes.androidnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    companion object {
        val NOTIFICATION_ID = 1
        var CHANNEL_ID = "channel_01"
        var CHANNEL_NAME: CharSequence = "dicoding channel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notif)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_notif))
                .setContentTitle(resources.getString(R.string.content_title))
                .setContentText(resources.getString(R.string.content_text))
                .setSubText(resources.getString(R.string.subtext))
                .setAutoCancel(true)

        // in android oreo and greater, we should add notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = CHANNEL_NAME as String?
            builder.setChannelId(CHANNEL_ID)

            notificationManager.createNotificationChannel(channel)
        }

        val notification = builder.build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }
}










































// end