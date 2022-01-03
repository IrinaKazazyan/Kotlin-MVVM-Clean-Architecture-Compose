package com.irinaKazazyan.kotlin_mvvm_clean.di

import com.irinaKazazyan.kotlin_mvvm_clean.common.Constants.BASE_URl
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.CoinApi
import com.irinaKazazyan.kotlin_mvvm_clean.data.repository.CoinRepositoryImpl
import com.irinaKazazyan.kotlin_mvvm_clean.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi) : CoinRepository{
        return CoinRepositoryImpl(api)
    }
}