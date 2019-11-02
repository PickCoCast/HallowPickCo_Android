package com.pickcocast.hallowpickco.data

import retrofit2.Call

interface RandomImageData {
    fun getImages(login:String): Call<List<RandomData>>
}