package com.example.aymanyasin_comp304_hands_on_test2_s24

import android.content.BroadcastReceiver
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val appDatabase: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
    private lateinit var stockInfoViewModel: StockInfoViewModel
    private lateinit var rdoGog: RadioButton
    private lateinit var rdoAmz: RadioButton
    private lateinit var rdoSsn: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stockInfoViewModel = ViewModelProvider(this).get(StockInfoViewModel::class.java)

        val stockInfoDao = appDatabase.getStockInfoDao()
        val repository = StockInfoRepository(stockInfoDao)

        rdoGog = findViewById<RadioButton>(R.id.rdGoogle)
        rdoAmz = findViewById<RadioButton>(R.id.rdAmazon)
        rdoSsn = findViewById<RadioButton>(R.id.rdSsnlf)

        val txtView = findViewById<TextView>(R.id.txtViewStock)
        val displayBtn = findViewById<Button>(R.id.btnDisplay)
        val insertBtn = findViewById<Button>(R.id.btnInsert)

        var stockSymbol: String

        insertBtn.setOnClickListener { // Insert hardcoded stock info into the database
            val stock1 = StockInfo("GOOGL", "Google", 760.00)
            val stock2 = StockInfo("AMZN", "Amazon", 990.00)
            val stock3 = StockInfo("SSNLF", "Samsung Electronics Ltd", 1040.00)

            stockInfoViewModel.insertStockInfo(stock1,)
            stockInfoViewModel.insertStockInfo(stock2,)
            stockInfoViewModel.insertStockInfo(stock3,)
        }
        displayBtn.setOnClickListener {

            if(rdoGog.isChecked) {
                stockSymbol = rdoGog.text.toString()

                GlobalScope.launch(Dispatchers.Main) {
                    val stockInfo = stockInfoViewModel.getStockInfoBySymbol(stockSymbol)
                    stockInfo?.let {
                        txtView.text = "Company Name: ${it.companyName}\nStock Quote: ${it.stockQuote}"

                        val intent = Intent("com.example.stock.broadcast")
                        intent.putExtra("company_name", it.companyName)
                        intent.putExtra("stock_quote", it.stockQuote)
                        sendBroadcast(intent)

                        Toast.makeText(baseContext, "Stock Info Received:\nCompany Name: ${it.companyName}\nStock Quote: ${it.stockQuote}", Toast.LENGTH_LONG).show()
                    } ?: run {
                        txtView.text = "No information found for the selected symbol."
                    }
                }
            }
            if(rdoAmz.isChecked){
                stockSymbol = rdoAmz.text.toString()

                GlobalScope.launch(Dispatchers.Main) {
                    val stockInfo = stockInfoViewModel.getStockInfoBySymbol(stockSymbol)
                    stockInfo?.let {
                        txtView.text = "Company Name: ${it.companyName}\nStock Quote: ${it.stockQuote}"

                        val intent = Intent("com.example.stock.broadcast")
                        intent.putExtra("company_name", it.companyName)
                        intent.putExtra("stock_quote", it.stockQuote)
                        sendBroadcast(intent)

                        Toast.makeText(baseContext, "Stock Info Received:\nCompany Name: ${it.companyName}\nStock Quote: ${it.stockQuote}", Toast.LENGTH_LONG).show()
                    } ?: run {
                        txtView.text = "No information found for the selected symbol."
                    }
                }
            }
            if(rdoSsn.isChecked){
                stockSymbol = rdoSsn.text.toString()

                GlobalScope.launch(Dispatchers.Main) {
                    val stockInfo = stockInfoViewModel.getStockInfoBySymbol(stockSymbol)
                    stockInfo?.let {
                        txtView.text = "Company Name: ${it.companyName}\nStock Quote: ${it.stockQuote}"

                        val intent = Intent("com.example.stock.broadcast")
                        intent.putExtra("company_name", it.companyName)
                        intent.putExtra("stock_quote", it.stockQuote)
                        sendBroadcast(intent)

                        Toast.makeText(baseContext, "Stock Info Received:\nCompany Name: ${it.companyName}\nStock Quote: ${it.stockQuote}", Toast.LENGTH_LONG).show()
                    } ?: run {
                        txtView.text = "No information found for the selected symbol."
                    }
                }
            }
        }
    }
}