package com.pickcocast.hallowpickco.util


import com.pickcocast.hallowpickco.model.GetKeepImageData
import com.pickcocast.hallowpickco.model.GetKeepImageDataResponse
import retrofit2.Call
import retrofit2.http.POST

interface NetworkService {
    // 3. 보관함
    @POST("category/box")
    fun getKeepImageResponse(
    ):Call<GetKeepImageDataResponse>
}