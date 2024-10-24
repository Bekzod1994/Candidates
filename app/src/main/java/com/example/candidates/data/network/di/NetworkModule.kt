package com.example.candidates.data.network.di

import com.example.candidates.data.Constants
import com.example.candidates.data.network.service.CandidateService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideConverter(json: Json): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @[Provides Singleton]
    fun provideJsonSerializer(): Json {
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    }

    @Singleton
    @Provides
    fun provideAuthorizedOkHttpClient(
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)

        return builder.build()
    }


    @Singleton
    @Provides
    fun provideTokenRetrofit(
        converter: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(converter)
            .addCallAdapterFactory(NetworkResponseAdapterFactory()).client(okHttpClient).build()


    @Singleton
    @Provides
    fun provideAuthAPIService(retrofit: Retrofit): CandidateService =
        retrofit.create(CandidateService::class.java)
}