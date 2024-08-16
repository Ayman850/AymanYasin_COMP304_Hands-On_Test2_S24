package com.example.aymanyasin_comp304_hands_on_test2_s24

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel

class StockInfoViewModel (application: Application) :AndroidViewModel(application) {

    private val repository: StockInfoRepository

    init {
        val dao = AppDatabase.getDatabase(application).getStockInfoDao()
        repository = StockInfoRepository(dao)
    }

    fun insertStockInfo(stockInfo: StockInfo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(stockInfo)
    }

    suspend fun getStockInfoBySymbol(stockSymbol: String) : StockInfo? {
        return repository.getStockInfoBySymbol(stockSymbol)
    }
}