package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin.GetCoinUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Provider {
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    fun provideCoinRepository(): CoinRepositoryImpl {
        return CoinRepositoryImpl()
    }

    fun provideGetCoinUseCase(): GetCoinUseCase {
        return GetCoinUseCase()
    }

    fun provideGetCoinsUseCase(): GetCoinsUseCase {
        return GetCoinsUseCase()
    }
}