package com.pickcocast.hallowpickco.ui.keep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.pickcocast.hallowpickco.R
import com.pickcocast.hallowpickco.ui.keep.adapter.KeepImageRVAdapter
import com.pickcocast.model.GetKeepImageDataResponse
import kotlinx.android.synthetic.main.activity_keep.*

class KeepActivity : AppCompatActivity() {

    lateinit var keepImageRVAdapter: KeepImageRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keep)

        getKeepImageRequest()
    }

    private fun getKeepImageRequest() {
        var tmp = ArrayList<GetKeepImageDataResponse>()
        tmp.add(
            GetKeepImageDataResponse(
                0,
                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
            )
        )
        tmp.add(
            GetKeepImageDataResponse(
                0,
                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
            )
        )
        tmp.add(
            GetKeepImageDataResponse(
                0,
                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
            )
        )
        tmp.add(
            GetKeepImageDataResponse(
                0,
                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
            )
        )
        tmp.add(
            GetKeepImageDataResponse(
                0,
                "https://hcom-graph.s3.ap-northeast-2.amazonaws.com/mbll_2019-08-16_143830.png"
            )
        )

        var keepRVAdapter = KeepImageRVAdapter(this@KeepActivity!!, tmp)
        rv_keep_image_list.apply {
            adapter = keepRVAdapter
            layoutManager = GridLayoutManager(this@KeepActivity, 2)
        }
        keepRVAdapter.notifyDataSetChanged()
    }
}
