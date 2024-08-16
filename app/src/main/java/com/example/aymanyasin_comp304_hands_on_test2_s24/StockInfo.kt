package com.example.aymanyasin_comp304_hands_on_test2_s24

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_info_table")
data class StockInfo(
    @PrimaryKey val stockSymbol: String,
    @ColumnInfo(name = "company_name") val companyName: String,
    @ColumnInfo(name = "stock_quote") val stockQuote: Double
)
