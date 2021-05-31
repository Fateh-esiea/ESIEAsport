package com.example.esieasport.presentation

import com.example.esieasport.presentation.SportApplication.Companion.context
import com.example.esieasport.presentation.api.SportApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singleton{
    companion object{
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024) // 10 MiB
        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val sportApi: SportApi = Retrofit.Builder()
                .baseUrl("https://wger.de/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(SportApi::class.java)
    }
}


