package com.example.appgame.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.appgame.data.local.dao.GameDao
import com.example.appgame.data.local.database.GameDatabase
import com.example.appgame.data.local.repository.LocalGameRepo
import com.example.appgame.data.remote.api.ApiConstants
import com.example.appgame.data.remote.api.GameApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameModule {

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

    @Provides
    fun providesGameDao(gameDatabase: GameDatabase ):GameDao = gameDatabase.gameDoa()

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context):GameDatabase
            = Room.databaseBuilder(context,GameDatabase::class.java,"game").fallbackToDestructiveMigration().build()

    @Provides
    fun providesGameRepository(gameDao: GameDao) : LocalGameRepo
            = LocalGameRepo(gameDao)
}