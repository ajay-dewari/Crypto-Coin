package me.ajay.cryptocoin.domain.use_cases.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.ajay.cryptocoin.common.Resource
import me.ajay.cryptocoin.data.remote.dto.toCoin
import me.ajay.cryptocoin.domain.models.Coin
import me.ajay.cryptocoin.domain.repositories.CoinRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
