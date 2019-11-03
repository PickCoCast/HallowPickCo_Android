package com.pickcocast.hallowpickco.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.pickcocast.hallowpickco.R
import com.pickcocast.hallowpickco.data.RandomData
import com.pickcocast.hallowpickco.data.RandomDataResponse
import com.pickcocast.hallowpickco.data.ServerRandomImageData
import kotlinx.android.synthetic.main.activity_loading.*
import kotlinx.android.synthetic.main.activity_random_image.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadingActivity : AppCompatActivity() {
    private val serverRandomImageData: ServerRandomImageData = ServerRandomImageData()
    private var cate: String = ""
    var loadedData : MutableList<RandomData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        init()
    }
    private fun init(){

        val anim = AnimationUtils.loadAnimation(this,R.anim.loading)
        img_loading.startAnimation(anim)

        //통신
        requestRandomImage()
    }



    private fun requestRandomImage(){
        Log.d("hojune","네트워킹 요청함")
        cate = "man"
        serverRandomImageData.getImages(cate).enqueue(object : Callback<RandomDataResponse> {
            override fun onFailure(call: Call<RandomDataResponse>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("hojune", "error : $t")
            }

            override fun onResponse(
                call: Call<RandomDataResponse>,
                response: Response<RandomDataResponse>
            ) {
                if (response.isSuccessful) {

                    val imageData = response.body()!!.data
                    Log.d("hojune", "${imageData} 임")
                    val name = imageData.name
                    val img = imageData.img
                    val category = imageData.category
                    val overview = imageData.overview
                    val rating = imageData.rating
                    val like = imageData.like
                    val buy_url = imageData.buy_url

                    val intent = Intent()
                    intent.putExtra("name",name)
                    intent.putExtra("img",img)
                    intent.putExtra("category",category)
                    intent.putExtra("overview",overview)
                    intent.putExtra("rating",rating)
                    intent.putExtra("like",like)
                    intent.putExtra("buy_url",buy_url)
                    setResult(Activity.RESULT_OK, intent)
                    finish()

                }
            }
        })
    }
}
