package com.irinaKazazyan.kotlin_mvvm_clean.domain.use_case

import com.irinaKazazyan.kotlin_mvvm_clean.common.Resource
import com.irinaKazazyan.kotlin_mvvm_clean.data.remote.dto.toCoinDetail
import com.irinaKazazyan.kotlin_mvvm_clean.domain.model.CoinDetail
import com.irinaKazazyan.kotlin_mvvm_clean.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}