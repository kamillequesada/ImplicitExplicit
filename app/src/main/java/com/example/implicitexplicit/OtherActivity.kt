package com.example.implicitexplicit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        findViewById<Button>(R.id.emailSend).setOnClickListener { sendEmail() }
        findViewById<Button>(R.id.openFacebook).setOnClickListener { openWebPage("http://www.facebook.com") }
        findViewById<Button>(R.id.wifiSettings).setOnClickListener { openWifiSettings() }
        findViewById<Button>(R.id.securitySettings).setOnClickListener { openSecuritySettings() }
        findViewById<Button>(R.id.sendTo).setOnClickListener { sendEmailTo() }
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse("http://www.facebook.com")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openWifiSettings() {
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openSecuritySettings() {
        val intent = Intent(Settings.ACTION_SECURITY_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            Toast.makeText(this, "Sorry you have no access to Security Settings!", Toast.LENGTH_LONG).show()
        }
    }

    private fun sendEmailTo() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
        }
        if (intent.resolveActivity(packageManager) != null) {
            Toast.makeText(this, "Sorry, we cannot find that email address.", Toast.LENGTH_LONG).show()
        }
    }
}