package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.di.Provider
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository

class CoinRepositoryImpl(): CoinRepository {
    private val api = Provider.coinPaprikaApi
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}