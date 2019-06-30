package com.example.SpringBootWithCoroutine.repository.infrastructure

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {
    val moshi: Moshi = Moshi.Builder().build()
    val moshiConverterFactory: MoshiConverterFactory = MoshiConverterFactory.create(moshi)

    fun okHttpClient(): OkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    fun buildRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/api/v1/")
            .client(okHttpClient())
            .addConverterFactory(moshiConverterFactory)
            .build()
}