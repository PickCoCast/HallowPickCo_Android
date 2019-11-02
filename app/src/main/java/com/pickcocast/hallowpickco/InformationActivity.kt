package com.pickcocast.hallowpickco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity() {
    private var Url: String="https://www.google.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        buying()

        linearLayout2.bringToFront()
    }

    private fun buying(){
        btn_info_buy.setOnClickListener{

            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", Url)
            setResult(Activity.RESULT_OK, intent) // StartActivityForResult
            startActivity(intent)
        }


    }
}
