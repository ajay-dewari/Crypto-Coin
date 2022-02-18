package me.ajay.cryptocoin.domain.repositories

import me.ajay.cryptocoin.data.remote.dto.CoinDetailDto
import me.ajay.cryptocoin.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}