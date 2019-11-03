package com.pickcocast.hallowpickco.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pickcocast.hallowpickco.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_male.setOnClickListener{
//            Log.d("현주", "눌려졌당")
            goRandomImageActivity("man")
        }

        btn_main_female.setOnClickListener(){
            goRandomImageActivity("woman")
        }

        btn_main_food.setOnClickListener(){
            goRandomImageActivity("food")
        }

        btn_main_etc.setOnClickListener(){
            goRandomImageActivity("etc")
        }
    }

    private fun goRandomImageActivity(category: String){
       val intent = Intent(this, RandomImageActivity::class.java)
        intent.putExtra("cate", category)
        startActivity(intent)
    }
}
