package com.panevrn.countriesapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestCountriesApi {
    @GET("name/{name}")
    suspend fun getCountryByName(@Path("name") cityName: String): List<Country>
}

var retrofit = Retrofit.Builder()
    //.baseUrl("https://countriesinfo21.herokuapp.com/") //второй вариант API: https://restcountries.eu/rest/v2/
    .baseUrl("https://restcountries.com/v2/") //второй вариант API:
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCountriesApi = retrofit.create(RestCountriesApi::class.java)