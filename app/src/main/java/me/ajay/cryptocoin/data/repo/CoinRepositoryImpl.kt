package me.ajay.cryptocoin.data.repo

import me.ajay.cryptocoin.data.remote.CoinPaprikaApi
import me.ajay.cryptocoin.data.remote.dto.CoinDetailDto
import me.ajay.cryptocoin.data.remote.dto.CoinDto
import me.ajay.cryptocoin.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}