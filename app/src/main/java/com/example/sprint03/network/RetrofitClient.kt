package com.example.sprint03.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private lateinit var retrofitClient: Retrofit

    fun getRetrofit(baseUrl: String): Retrofit {
        retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitClient
    }
}