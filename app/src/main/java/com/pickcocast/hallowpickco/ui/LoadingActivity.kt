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
import com.pickcocast.hallowpickco.data.ServerRandomImageData
import kotlinx.android.synthetic.main.activity_loading.*
import kotlinx.android.synthetic.main.activity_random_image.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadingActivity : AppCompatActivity() {
    private val serverRandomImageData: ServerRandomImageData = ServerRandomImageData()
    private var login: String = ""
    var loadedData : List<RandomData> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        init()
    }
    private fun init(){

        val anim = AnimationUtils.loadAnimation(this,R.anim.loading)
        img_loading.startAnimation(anim)
        requestRandomImage()
    }

    private fun requestRandomImage(){
        login = ""
        serverRandomImageData.getImages(login).enqueue(object : Callback<List<RandomData>> {
            override fun onFailure(call: Call<List<RandomData>>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("hojune", "error : $t")
            }

            override fun onResponse(
                call: Call<List<RandomData>>,
                response: Response<List<RandomData>>
            ) {
                if (response.isSuccessful) {
                    val imageData = response.body()!!

                    val name = imageData.get(0).name
                    val img = imageData.get(0).img
                    val category = imageData.get(0).category
                    val overview = imageData.get(0).overview
                    val rating = imageData.get(0).rating
                    val like = imageData.get(0).like
                    val buy_url = imageData.get(0).buy_url

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
