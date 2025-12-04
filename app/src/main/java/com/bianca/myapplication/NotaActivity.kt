package com.bianca.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        // Back button
        findViewById<ImageView>(R.id.btnBackNota).setOnClickListener { finish() }

        val tvNamaCustomer = findViewById<TextView>(R.id.tvNamaCustomer)
        val tvDetail = findViewById<TextView>(R.id.tvDetailPesanan)
        val tvTotal = findViewById<TextView>(R.id.tvTotalHarga)

        // =============================
        // ✔ AMBIL DATA DARI CHECKOUT
        // =============================
        val namaCustomer = intent.getStringExtra("namaCustomer") ?: ""
        val orderList = intent.getStringExtra("orderList") ?: ""
        val total = intent.getIntExtra("total", 0)

        // =============================
        // ✔ TAMPILKAN DI NOTA
        // =============================
        tvNamaCustomer.text = "Nama Customer: $namaCustomer"
        tvDetail.text = orderList
        tvTotal.text = "Total Pembayaran: Rp $total"
    }
}
