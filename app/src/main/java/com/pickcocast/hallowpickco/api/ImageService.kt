package com.pickcocast.hallowpickco.api

import com.pickcocast.hallowpickco.data.RandomData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageService {
    @GET("/users/{login}")// 수정 필요
    fun getImageData(
        @Path("login") login : String
    ) : Call<List<RandomData>>
}