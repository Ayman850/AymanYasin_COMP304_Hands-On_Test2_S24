package com.example.aymanyasin_comp304_hands_on_test2_s24

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class StockBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "com.example.stock.broadcast") {
            val companyName = intent.getStringExtra("company_name")
            val stockQuote = intent.getDoubleExtra("stock_quote", Double.NaN)

            val message = "Stock Info Received:\nCompany Name: $companyName\nStock Quote: $stockQuote"
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}