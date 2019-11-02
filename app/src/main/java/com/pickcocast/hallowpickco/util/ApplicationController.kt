package com.pickcocast.hallowpickco.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApplicationController {
    private val baseURL = "http://0.0.0.0:0/"
    lateinit var networkService:NetworkService

    init {
        buildNetwork()
    }

    fun buildNetwork(){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        networkService = retrofit.create(NetworkService::class.java)

    }

}