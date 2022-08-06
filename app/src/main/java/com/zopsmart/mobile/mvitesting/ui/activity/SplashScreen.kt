package com.zopsmart.mobile.mvitesting.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.zopsmart.mobile.mvitesting.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({ // This method will be executed once the timer is over
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 5000)
    }
}
