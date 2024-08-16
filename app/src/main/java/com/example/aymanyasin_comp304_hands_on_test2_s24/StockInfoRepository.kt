package com.example.aymanyasin_comp304_hands_on_test2_s24

class StockInfoRepository(private val stockInfoDao: StockInfoDao) {

    suspend fun insert(stockInfo: StockInfo) {
        stockInfoDao.insert(stockInfo)
    }

    suspend fun getStockInfoBySymbol(stockSymbol: String): StockInfo? {
        return stockInfoDao.getStockInfoBySymbol(stockSymbol)
    }
}

