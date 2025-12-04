package com.bianca.myapplication

import android.content.Intent
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

        // GET DATA DARI BAKERY
        val name = intent.getStringExtra("namaCustomer") ?: "-"

        val croissant = intent.getIntExtra("croissant", 0)
        val donut = intent.getIntExtra("donut", 0)
        val chocolate = intent.getIntExtra("chocolate", 0)
        val milkshake = intent.getIntExtra("milkshake", 0)
        val chocolateVariant = intent.getStringExtra("chocolateVariant") ?: ""

        // HARGA
        val hCroissant = 12000
        val hDonut = 10000
        val hChocolate = 15000
        val hMilkshake = 18000

        // Detail pesanan
        var orderList = ""

        if (croissant > 0) orderList += "Croissant x$croissant = Rp ${croissant * hCroissant}\n"
        if (donut > 0) orderList += "Donut x$donut = Rp ${donut * hDonut}\n"
        if (chocolate > 0) orderList += "Chocolate ($chocolateVariant) x$chocolate = Rp ${chocolate * hChocolate}\n"
        if (milkshake > 0) orderList += "Milkshake x$milkshake = Rp ${milkshake * hMilkshake}\n"

        if (orderList == "") orderList = "Tidak ada pesanan."

        val total = (croissant * hCroissant) +
                (donut * hDonut) +
                (chocolate * hChocolate) +
                (milkshake * hMilkshake)

        // Tampilkan
        tvFinalName.text = "Customer: $name"
        tvFinalOrder.text = orderList
        tvFinalTotal.text = "Total Pembayaran: Rp $total"

        // Pindah ke NotaActivity
        btnPrint.setOnClickListener {
            val intent = Intent(this, NotaActivity::class.java)

            intent.putExtra("namaCustomer", name)
            intent.putExtra("orderList", orderList)
            intent.putExtra("total", total)

            // kirim item untuk nota jika perlu
            intent.putExtra("croissant", croissant)
            intent.putExtra("donut", donut)
            intent.putExtra("chocolate", chocolate)
            intent.putExtra("milkshake", milkshake)
            intent.putExtra("chocolateVariant", chocolateVariant)

            startActivity(intent)
        }
    }
}
