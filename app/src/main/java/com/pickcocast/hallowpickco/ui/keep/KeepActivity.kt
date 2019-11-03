package com.pickcocast.hallowpickco.ui.keep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.pickcocast.hallowpickco.R
import com.pickcocast.hallowpickco.model.GetKeepImageData
import com.pickcocast.hallowpickco.ui.keep.adapter.KeepImageRVAdapter
import com.pickcocast.hallowpickco.model.GetKeepImageDataResponse
import com.pickcocast.hallowpickco.util.ApplicationController
import kotlinx.android.synthetic.main.activity_keep.*
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import javax.security.auth.callback.Callback

class KeepActivity : AppCompatActivity() {
    val networkService = ApplicationController.networkService
    var data= ArrayList<String>()

    lateinit var keepImageRVAdapter: KeepImageRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keep)

        getKeepImageRequest()
    }

    private fun getKeepImageRequest() {
//        var tmp = ArrayList<GetKeepImageDataResponse>()
//        tmp.add(
//            GetKeepImageDataResponse(
//                0,
//                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
//            )
//        )
//        tmp.add(
//            GetKeepImageDataResponse(
//                0,
//                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
//            )
//        )
//        tmp.add(
//            GetKeepImageDataResponse(
//                0,
//                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
//            )
//        )
//        tmp.add(
//            GetKeepImageDataResponse(
//                0,
//                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
//            )
//        )
//        tmp.add(
//            GetKeepImageDataResponse(
//                0,
//                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
//            )
//        )

        var getKeepResponse = networkService.getKeepImageResponse()
        getKeepResponse.enqueue(object : retrofit2.Callback<GetKeepImageDataResponse> {
            override fun onFailure(call: Call<GetKeepImageDataResponse>, t: Throwable) {
                Log.e("KeepActivity-fail", t.toString())
            }

            override fun onResponse(
                call: Call<GetKeepImageDataResponse>,
                response: Response<GetKeepImageDataResponse>
            ) {
                if (response.isSuccessful){
                    try{
                        data   = response.body()!!.data
                        Log.d("현주", data.toString())
                        keepImageRVAdapter = KeepImageRVAdapter(this@KeepActivity!!, data)
                        rv_keep_image_list.apply {
                            adapter = keepImageRVAdapter
                            layoutManager = GridLayoutManager(this@KeepActivity, 2)
                        }
                        keepImageRVAdapter.notifyDataSetChanged()
                    }catch (e: Exception){

                    }
                }
            }
        })




    }
}

