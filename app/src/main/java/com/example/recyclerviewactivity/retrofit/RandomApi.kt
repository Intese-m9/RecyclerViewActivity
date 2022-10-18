package com.example.recyclerviewactivity.retrofit

import com.example.recyclerviewactivity.jsondata.Main
import retrofit2.Response
import retrofit2.http.GET

interface RandomApi {
    @GET("/api/activity?type=recreational")
    suspend fun getRecreational(): Response<Main>
    @GET("/api/activity?type=education")
    suspend fun getEducation(): Response<Main>

}