package com.example.aymanyasin_comp304_hands_on_test2_s24

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(stockInfo: StockInfo)

    @Query("SELECT * FROM stock_info_table WHERE stockSymbol = :symbol")
    suspend fun getStockInfoBySymbol(symbol: String): StockInfo?
}


