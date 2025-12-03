package com.bianca.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val tvCartList = findViewById<TextView>(R.id.tvCartList)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        // GET DATA FROM INTENT
        val namaCustomer = intent.getStringExtra("namaCustomer") ?: ""

        val croissant = intent.getIntExtra("croissant", 0)
        val donut = intent.getIntExtra("donut", 0)
        val chocolate = intent.getIntExtra("chocolate", 0)
        val milkshake = intent.getIntExtra("milkshake", 0)
        val chocolateVariant = intent.getStringExtra("chocolateVariant") ?: ""

        // HARGA
        val priceCroissant = 12000
        val priceDonut = 10000
        val priceChocolate = 15000
        val priceMilkshake = 18000

        var total = 0
        val orderText = StringBuilder()

        if (croissant > 0) {
            val subtotal = croissant * priceCroissant
            total += subtotal
            orderText.append("Croissant x$croissant = Rp $subtotal\n")
        }

        if (donut > 0) {
            val subtotal = donut * priceDonut
            total += subtotal
            orderText.append("Donut x$donut = Rp $subtotal\n")
        }

        if (chocolate > 0) {
            val subtotal = chocolate * priceChocolate
            total += subtotal
            orderText.append("Chocolate ($chocolateVariant) x$chocolate = Rp $subtotal\n")
        }

        if (milkshake > 0) {
            val subtotal = milkshake * priceMilkshake
            total += subtotal
            orderText.append("Strawberry Milkshake x$milkshake = Rp $subtotal\n")
        }

        tvCartList.text = orderText.toString()
        tvTotal.text = "Total: Rp $total"

        btnCheckout.setOnClickListener {

            val checkoutIntent = Intent(this, CheckoutActivity::class.java)

            checkoutIntent.putExtra("orderList", orderText.toString())
            checkoutIntent.putExtra("total", total)
            checkoutIntent.putExtra("namaCustomer", namaCustomer)

            startActivity(checkoutIntent)
        }
    }
}
