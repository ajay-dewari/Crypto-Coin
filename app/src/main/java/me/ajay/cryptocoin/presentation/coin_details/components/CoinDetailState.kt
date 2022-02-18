package me.ajay.cryptocoin.presentation.coin_details.components

import me.ajay.cryptocoin.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
