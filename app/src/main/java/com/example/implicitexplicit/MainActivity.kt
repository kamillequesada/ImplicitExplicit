package com.example.implicitexplicit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var etUsername = findViewById(R.id.etUsername) as EditText
        var etPassword = findViewById(R.id.etPassword) as EditText
        var loginBtn = findViewById(R.id.loginBtn) as Button

        loginBtn.setOnClickListener {
            if(etUsername.text.toString().equals("kamille25")
               && (etPassword.text.toString().equals("123456"))){
         val intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
            }else {
             Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show()
         }
        }
}}