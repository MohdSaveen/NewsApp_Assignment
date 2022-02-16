package com.example.newsappassignment.model.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object {
        private const val baseurl = "https://newsapi.org/"
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
                )
                .build()
        }

        val api: ApiServices = getRetrofit().create(ApiServices::class.java)
    }
}
