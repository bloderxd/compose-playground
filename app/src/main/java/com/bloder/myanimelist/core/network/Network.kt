package com.bloder.myanimelist.core.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val MY_ANIME_LIST_BASE_URL = "https://api.jikan.moe/v3/"

fun <E> networkingWith(protocol: Class<E>): E {
    val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
   return Retrofit.Builder()
       .baseUrl(MY_ANIME_LIST_BASE_URL)
       .addConverterFactory(MoshiConverterFactory.create(moshi))
       .client(client)
       .build()
       .create(protocol)
}