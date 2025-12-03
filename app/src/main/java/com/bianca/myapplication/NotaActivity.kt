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
        findViewById<ImageView>(R.id.btnBackNota).setOnClickListener {
            finish()
        }

        val tvNamaCustomer = findViewById<TextView>(R.id.tvNamaCustomer)
        val tvDetail = findViewById<TextView>(R.id.tvDetailPesanan)
        val tvTotal = findViewById<TextView>(R.id.tvTotalHarga)

        // Ambil data dari Intent
        val namaCustomer = intent.getStringExtra("nama")
        val croissant = intent.getIntExtra("croissant", 0)
        val donut = intent.getIntExtra("donut", 0)
        val chocolate = intent.getIntExtra("chocolate", 0)
        val milkshake = intent.getIntExtra("milkshake", 0)

        // Harga
        val hCroissant = 12000
        val hDonut = 10000
        val hChocolate = 15000
        val hMilkshake = 18000

        // Detail Pesanan
        var detail = ""

        if (croissant > 0) detail += "Croissant x$croissant = Rp ${croissant * hCroissant}\n"
        if (donut > 0) detail += "Donut x$donut = Rp ${donut * hDonut}\n"
        if (chocolate > 0) detail += "Chocolate x$chocolate = Rp ${chocolate * hChocolate}\n"
        if (milkshake > 0) detail += "Milkshake x$milkshake = Rp ${milkshake * hMilkshake}\n"

        if (detail == "") {
            detail = "Tidak ada pesanan."
        }

        // Total
        val total = (croissant * hCroissant) +
                (donut * hDonut) +
                (chocolate * hChocolate) +
                (milkshake * hMilkshake)

        // Tampilkan
        tvNamaCustomer.text = "Nama Customer: $namaCustomer"
        tvDetail.text = detail
        tvTotal.text = "Total Pembayaran: Rp $total"
    }
}
