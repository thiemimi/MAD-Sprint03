package com.example.sprint03.network

import com.example.sprint03.model.Lead
import com.example.sprint03.model.PostLead
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface APIServices {

    @GET("/leads")
    fun getLeads(): Call<List<Lead>>

    @POST("/leads")
    fun postLeads(post: PostLead): Call<Lead>
}