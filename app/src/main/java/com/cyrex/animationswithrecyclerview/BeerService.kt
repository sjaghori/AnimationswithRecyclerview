package com.cyrex.animationswithrecyclerview

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface BeerService {

    @GET("beers?per_page=80")
    suspend fun getBeers(): Response<List<Beer>>

}

/** Pretend [BeerService] constructor. */
@Suppress("FunctionName")
fun BeerService(): BeerService {
    return Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}