package com.irinaKazazyan.kotlin_mvvm_clean.presentation.coin_list

import com.irinaKazazyan.kotlin_mvvm_clean.domain.model.Coin
import java.util.Collections.emptyList

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)