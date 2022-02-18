package me.ajay.cryptocoin.presentation.coin_list.components

import me.ajay.cryptocoin.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
