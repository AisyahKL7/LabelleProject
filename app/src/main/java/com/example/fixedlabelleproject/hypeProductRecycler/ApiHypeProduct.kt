package com.example.fixedlabelleproject.hypeProductRecycler

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiHypeProduct {
    @GET("rest/v1/hype_prodct?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<HypedataAPI>>
}