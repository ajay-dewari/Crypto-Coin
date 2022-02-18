package me.ajay.cryptocoin.domain.use_cases.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.ajay.cryptocoin.common.Resource
import me.ajay.cryptocoin.data.remote.dto.toCoinDetail
import me.ajay.cryptocoin.domain.models.CoinDetail
import me.ajay.cryptocoin.domain.repositories.CoinRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}