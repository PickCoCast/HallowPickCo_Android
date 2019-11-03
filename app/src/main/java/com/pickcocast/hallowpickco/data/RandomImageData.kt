package com.pickcocast.hallowpickco.data

import retrofit2.Call

interface RandomImageData {
    fun getImages(cate:String): Call<RandomDataResponse>
}