package com.example.notetesting

import com.example.notetesting.Model.ReadDataModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitfetchApi {

    //the getting path from the base url
    //we use GET to read from server base url
    //we use call

    @GET("15rxxk")
    fun  getData():Call<List<ReadDataModel>>





}