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
    private var login: String = ""
    var loadedData : MutableList<RandomData> = mutableListOf()

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
            if(!loadedData.isEmpty()){
                val intent = Intent(this@RandomImageActivity,InformationActivity::class.java)
                intent.putExtra("name",loadedData.get(0).name)
                intent.putExtra("img",loadedData.get(0).img)
                intent.putExtra("category",loadedData.get(0).category)
                intent.putExtra("overview",loadedData.get(0).overview)
                intent.putExtra("rating",loadedData.get(0).rating)
                intent.putExtra("like",loadedData.get(0).like)
                intent.putExtra("buy_url",loadedData.get(0).buy_url)
                startActivity(intent)
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
                    val name = data!!.getStringExtra("name").toString()
                    val img = data!!.getStringExtra("img").toString()
                    val category = data!!.getStringExtra("category").toString()
                    val overview = data!!.getStringExtra("overview").toString()
                    val rating = data!!.getStringExtra("rating").toString()
                    val like = data!!.getStringExtra("like").toString()
                    val buy_url = data!!.getStringExtra("buy_url").toString()

                    val randomData = RandomData(name,img,category,overview,rating,like,buy_url)
                    loadedData.add(0,randomData)

                    tv_randomimage_title.text = "이런건 어때요?"

                }
            }
        }
    }

}
