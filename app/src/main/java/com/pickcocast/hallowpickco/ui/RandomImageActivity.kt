package com.pickcocast.hallowpickco.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.pickcocast.hallowpickco.R
import com.pickcocast.hallowpickco.data.DummyData
import com.pickcocast.hallowpickco.data.RandomData
import com.pickcocast.hallowpickco.data.ServerRandomImageData
import kotlinx.android.synthetic.main.activity_random_image.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomImageActivity : AppCompatActivity() {
    var isLove = false
    private val serverRandomImageData: ServerRandomImageData = ServerRandomImageData()
    lateinit var loadedData : RandomData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_image)
        init()
    }
    private fun init() {
        //좋아요 버튼
        btn_randomimage_love.setOnClickListener {
            if(!isLove){
                btn_randomimage_love.setImageResource(R.drawable.ic_like)
                isLove = true
            }else{
                btn_randomimage_love.setImageResource(R.drawable.ic_like_empty)
                isLove = false
            }
        }
        //다시 요청
        btn_randomimage_reload.setOnClickListener {
            //레트로핏으로 데이터 요청. 완료되면 UI 재적용.(애니메이션 호출 후 데이터 받아오면 다시 데이터 표시하기)
            val intent = Intent(this@RandomImageActivity,LoadingActivity::class.java)
            startActivityForResult(intent,200)

        }
        //정보 보기
        btn_randomimage_showinfo.setOnClickListener {
            if(!loadedData.name.equals("")){
                val intent = Intent(this@RandomImageActivity,InformationActivity::class.java)
                intent.putExtra("name",loadedData.name)
                intent.putExtra("img",loadedData.img)
                intent.putExtra("category",loadedData.category)
                intent.putExtra("overview",loadedData.overview)
                intent.putExtra("rating",loadedData.rating)
                intent.putExtra("like",loadedData.like)
                intent.putExtra("buy_url",loadedData.buy_url)
                startActivity(intent)
                finish()
            }else{
                sendToast("불러온 데이터 없음")
            }
        }
        btn_randomimage_reload.callOnClick()
    }

    private fun sendToast(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                200 -> {
                    val name = data!!.getStringExtra("name")
                    val img = data.getStringExtra("img")
                    val category = data.getStringExtra("category")
                    val overview = data.getStringExtra("overview")
                    val rating = data.getStringExtra("rating")
                    val like = data.getIntExtra("like",0)
                    val buy_url = data.getStringExtra("buy_url")

                    loadedData = RandomData(0,name,img,category,overview,rating,like,buy_url,0)

                    Glide.with(this).load(img).into(img_randomimage)
                    tv_randomimage_name.text = name
                    tv_randomimage_rating.text = rating


                    tv_randomimage_title.text = "이런건 어때요?"

                }
            }
        }
    }

}
