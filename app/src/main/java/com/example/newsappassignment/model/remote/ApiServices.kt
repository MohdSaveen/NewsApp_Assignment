package com.example.newsappassignment.model.remote

import com.example.newsappassignment.model.remote.responsemodel.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("v2/everything")
    suspend fun getData(
        @Query("q") sources: String = "general",
        @Query("apiKey") apikey: String = "88fa63059aca4b29ae173f851e29d608",
        @Query("pageSize") pageSize: Int = 100,
        @Query("sortBy") SORT_BY: String = "publishedAt"
    ): ResponseDTO

}