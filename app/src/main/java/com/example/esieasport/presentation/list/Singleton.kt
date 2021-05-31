package com.example.esieasport.presentation.list

import com.example.esieasport.presentation.api.SportApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Singleton{
    companion object{
        val sportApi: SportApi = Retrofit.Builder()
                .baseUrl("https://wger.de/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SportApi::class.java)
    }
}


