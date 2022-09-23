package com.example.appgame.di

import com.example.appgame.data.api.ApiConstants
import com.example.appgame.data.api.GameApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameApiModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): GameApi {
        return builder.
        build().
        create(GameApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder{
        return Retrofit.Builder().
        baseUrl(ApiConstants.BASE_URL).
        addConverterFactory(MoshiConverterFactory.create())
    }
}