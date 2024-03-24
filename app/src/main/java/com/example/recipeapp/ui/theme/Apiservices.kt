package com.example.recipeapp.ui.theme

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit= Retrofit.Builder().baseUrl("www.themealdb.com/api/json/v1/1/categories")
    .addConverterFactory((GsonConverterFactory.create())).build()

     val recipeService= retrofit.create(Apiservices::class.java)

interface Apiservices {

    @GET("category.php")
    suspend fun getCategory():CategoryResponse
}