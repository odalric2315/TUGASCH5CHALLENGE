package com.percobaan.mysprgames

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstances: Bundle?) {
        super.onCreate(savedInstances)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(this,"Welcome", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
        finish()
        },3000)
    }
}
