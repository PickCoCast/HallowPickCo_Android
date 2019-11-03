package com.pickcocast.hallowpickco.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pickcocast.hallowpickco.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val SPLASH_TIME_OUT = 3000
        try{
            val intent = Intent(this, MainActivity::class.java)

            Handler().postDelayed({
                //Do some stuff here, like implement deep linking
                startActivity(intent)
                finish()
            }, SPLASH_TIME_OUT.toLong())

        }
        catch (e: Exception){
            return
        }
    }
}
