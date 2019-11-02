package com.pickcocast.hallowpickco.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pickcocast.hallowpickco.R
import com.pickcocast.hallowpickco.ui.keep.KeepActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_male.setOnClickListener{
//            Log.d("현주", "눌려졌당")
            //goKeepActivity()
        }
    }

    private fun goKeepActivity(){
       val intent = Intent(this, KeepActivity::class.java)
        startActivity(intent)
    }
}
