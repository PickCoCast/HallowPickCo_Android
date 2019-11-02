package com.pickcocast.hallowpickco.data

import com.pickcocast.hallowpickco.api.ImageServiceImpl
import retrofit2.Call

class ServerRandomImageData :RandomImageData{
    override fun getImages(login:String): Call<List<RandomData>> {
        return ImageServiceImpl.service.getImageData(login)
    }
}