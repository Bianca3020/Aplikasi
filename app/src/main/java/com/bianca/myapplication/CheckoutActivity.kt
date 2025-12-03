package com.bianca.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val tvFinalName = findViewById<TextView>(R.id.tvFinalName)
        val tvFinalOrder = findViewById<TextView>(R.id.tvFinalOrder)
        val tvFinalTotal = findViewById<TextView>(R.id.tvFinalTotal)
        val btnPrint = findViewById<Button>(R.id.btnPrint)

        val name = intent.getStringExtra("namaCustomer") ?: "-"
        val orderList = intent.getStringExtra("orderList") ?: ""
        val total = intent.getIntExtra("total", 0)

        tvFinalName.text = "Customer: $name"
        tvFinalOrder.text = orderList
        tvFinalTotal.text = "Total Pembayaran: Rp $total"

        btnPrint.setOnClickListener {
            Toast.makeText(this, "Struk dicetak!", Toast.LENGTH_LONG).show()
        }
    }
}
