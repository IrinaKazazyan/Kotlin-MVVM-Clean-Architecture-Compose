package com.irinaKazazyan.kotlin_mvvm_clean.data.remote

import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.CoinDetailDto
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}