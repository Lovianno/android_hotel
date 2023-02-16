package com.example.laundry

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
     fun getPengguna(): Call<SocialMed>
}