package com.example.robokalam.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class QuoteResponse(val q: String, val a: String)

interface QuoteApiService {
    @GET("today")
    suspend fun getTodayQuote(): List<QuoteResponse>

    companion object {
        fun create(): QuoteApiService {
            return Retrofit.Builder()
                .baseUrl("https://zenquotes.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuoteApiService::class.java)
        }
    }
}