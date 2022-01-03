package com.irinaKazazyan.kotlin_mvvm_clean.domain.use_case

import com.irinaKazazyan.kotlin_mvvm_clean.common.Resource
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.toCoin
import com.irinaKazazyan.kotlin_mvvm_clean.domain.model.Coin
import com.irinaKazazyan.kotlin_mvvm_clean.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}