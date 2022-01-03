package com.irinaKazazyan.kotlin_mvvm_clean.presentation.coin_detail

import com.irinaKazazyan.kotlin_mvvm_clean.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)