package com.pickcocast.hallowpickco.data

import com.google.gson.annotations.SerializedName

data class RandomDataResponse(
    var message: String,
    var data: RandomData
)

data class RandomData(//수정 필요
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("img_url")
    val img : String,
    @SerializedName("cate")
    val category : String,
    @SerializedName("intro")
    val overview : String,
    @SerializedName("star")
    val rating : String,
    @SerializedName("likes")
    val like : Int,
    @SerializedName("buylink")
    val buy_url : String,
    @SerializedName("isliked")
    val isliked : Int

)