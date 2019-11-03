package com.pickcocast.hallowpickco.api

import com.pickcocast.hallowpickco.data.RandomDataResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface ImageService {
    @POST("/category/{cate}")// 수정 필요
    fun getImageData(
        @Path("cate") cate : String
    ) : Call<RandomDataResponse>
}