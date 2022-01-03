package com.irinaKazazyan.kotlin_mvvm_clean.data.repository

import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.CoinApi
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.CoinDetailDto
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.CoinDto
import com.irinaKazazyan.kotlin_mvvm_clean.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}