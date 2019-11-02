package com.pickcocast.hallowpickco.util

import com.pickcocast.hallowpickco.model.GetKeepImageDataResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    // 3. 보관함
    @GET("")
    fun getKeepImageResponse(
    ):Call<GetKeepImageDataResponse>
}