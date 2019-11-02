package com.pickcocast.hallowpickco.data

import com.google.gson.annotations.SerializedName

data class RandomData(//수정 필요
    @SerializedName("name")
    val name : String,
    @SerializedName("img")
    val img : String,
    @SerializedName("category")
    val category : String,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("rating")
    val rating : String,
    @SerializedName("like")
    val like : String,
    @SerializedName("buy_url")
    val buy_url : String
)