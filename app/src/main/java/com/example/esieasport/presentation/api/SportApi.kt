package com.example.esieasport.presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface SportApi {
    @GET("exercisecategory")
    fun getMuscleList(): Call<MuscleListResponse>
}