package com.example.esieasport.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.esieasport.presentation.api.MuscleListResponse as MuscleListResponse

interface SportApi {
  @GET("exercisecategory")
  fun getMuscleList(): Call<MuscleListResponse>

   // @GET("exercise/?category=10")
   // fun getMuscleDetail(@Path("id") id:String): Call<MuscleDetailResponse>

  //Test:
 //@GET("exercise/{category}?format=json")
 //fun getMuscleList(@Path("category") id: String): Call<MuscleListResponse1>
 // @GET("exercisecategory")  //{category}?format=json
 // fun getMuscleDetail(): Call<MuscleDetailResponse>  //@Path("category") id: String

  @GET("exercise/?category=id")  //{category}?format=json
  fun getMuscleDetail(@Query("id") id: Int): Call<MuscleDetailResponse>   //@Path("category") id: String
}

