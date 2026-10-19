package com.messageai.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.text.DateFormat
import java.util.Date

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 48, 32, 32)
        }
        val title = TextView(this).apply { text = "Message AI — גרסת בדיקה"; textSize = 23f }
        val result = TextView(this).apply { textSize = 16f }
        val access = Button(this).apply {
            text = "הפעל גישה להתראות"
            setOnClickListener { startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)) }
        }
        val scan = Button(this).apply {
            text = "סרוק הודעות שנקלטו"
            setOnClickListener {
                val prefs = getSharedPreferences("captured", MODE_PRIVATE)
                val messages = prefs.all.entries.sortedByDescending { it.key }.take(100)
                val time = DateFormat.getDateTimeInstance().format(Date())
                result.text = "סריקה אחרונה: $time\nנקלטו: ${prefs.all.size}\n\n" +
                    messages.joinToString("\n") { it.value.toString() }
            }
        }
        val clear = Button(this).apply {
            text = "מחק הודעות שנאספו"
            setOnClickListener {
                getSharedPreferences("captured", MODE_PRIVATE).edit().clear().apply()
                result.text = "המידע המקומי נמחק"
            }
        }
        root.addView(title); root.addView(access); root.addView(scan); root.addView(clear); root.addView(result)
        setContentView(root)
    }
}