package com.irinaKazazyan.kotlin_mvvm_clean.domain.repository

import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.CoinDetailDto
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailDto
}