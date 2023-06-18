package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin.GetCoinUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Provider {

    val coinPaprikaApi by lazy { provideCoinPaprikaApi() }
    val coinRepository by lazy { provideCoinRepository() }
    val getCoinUseCase by lazy { provideGetCoinUseCase() }
    val getCoinsUseCase by lazy { provideGetCoinsUseCase() }

    private fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    private fun provideCoinRepository(): CoinRepositoryImpl {
        return CoinRepositoryImpl()
    }

    private fun provideGetCoinUseCase(): GetCoinUseCase {
        return GetCoinUseCase()
    }

    private fun provideGetCoinsUseCase(): GetCoinsUseCase {
        return GetCoinsUseCase()
    }
}