package com.pickcocast.hallowpickco.data

import com.pickcocast.hallowpickco.api.ImageServiceImpl
import retrofit2.Call

class ServerRandomImageData :RandomImageData{
    override fun getImages(cate:String): Call<RandomDataResponse> {
        return ImageServiceImpl.service.getImageData(cate)
    }
}