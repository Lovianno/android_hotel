package com.example.laundry.Api

import com.example.laundry.*
import com.example.laundry.Model.FoodResponse
import com.example.laundry.Model.FoodResponseItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    fun getPost() : Call<ArrayList<PostResponseItem>>

    @GET("http://192.168.1.42:45455/api/pegawais")
    fun getPegawai() : Call<ArrayList<PegawaiResponseItem>>

    @GET("http://192.168.1.42:45455/api/Layanans")
    fun getLayanan() : Call<ArrayList<LayananResponseItem>>

    @FormUrlEncoded
    @POST("http://192.168.137.1:45455/api/FoodsAndDrinks")
    fun createFood(
        @Field("price") price: Int,
        @Field("name") name: String,
        @Field("photo") photo: String,
        @Field("type") type: Char
    ): Call<ArrayList<FoodResponseItem>>

}