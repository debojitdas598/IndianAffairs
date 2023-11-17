package com.example.indianaffairs.di

import com.example.indianaffairs.api.IndianAffairsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://newsi-api.p.rapidapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesIndianAffairsAPI(retrofit: Retrofit):IndianAffairsAPI{
        return retrofit.create(IndianAffairsAPI::class.java)
    }


}
