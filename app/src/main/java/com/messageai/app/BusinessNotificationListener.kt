package com.messageai.app

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class BusinessNotificationListener : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        if (sbn?.packageName != "com.whatsapp.w4b") return
        val extras = sbn.notification.extras
        val title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
        val body = extras.getCharSequence(Notification.EXTRA_TEXT)?.toString().orEmpty()
        if (body.isBlank()) return
        val prefs = getSharedPreferences("captured", MODE_PRIVATE)
        val id = System.currentTimeMillis().toString()
        prefs.edit().putString(id, "$title: $body").apply()
    }
}