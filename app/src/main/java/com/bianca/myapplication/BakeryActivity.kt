package com.bianca.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BakeryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bakery)

        // BACK
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // INPUT FIELD
        val etNamaCustomer = findViewById<EditText>(R.id.etNamaCustomer)

        val etCroissant = findViewById<EditText>(R.id.etJmlCroissant)
        val etDonut = findViewById<EditText>(R.id.etJmlDonut)
        val etChocolate = findViewById<EditText>(R.id.etJmlCappuccino)
        val etMilkshake = findViewById<EditText>(R.id.etJmlMilkshake)

        val spChocolate = findViewById<Spinner>(R.id.spChocolate)

        val btnPesan = findViewById<Button>(R.id.btnPesan)

        btnPesan.setOnClickListener {

            val namaCustomer = etNamaCustomer.text.toString()

            val croissant = etCroissant.text.toString().toIntOrNull() ?: 0
            val donut = etDonut.text.toString().toIntOrNull() ?: 0
            val chocolate = etChocolate.text.toString().toIntOrNull() ?: 0
            val milkshake = etMilkshake.text.toString().toIntOrNull() ?: 0

            val chocolateVariant = spChocolate.selectedItem.toString()

            val intent = Intent(this, CartActivity::class.java)

            intent.putExtra("namaCustomer", namaCustomer)
            intent.putExtra("croissant", croissant)
            intent.putExtra("donut", donut)
            intent.putExtra("chocolate", chocolate)
            intent.putExtra("milkshake", milkshake)
            intent.putExtra("chocolateVariant", chocolateVariant)

            startActivity(intent)
        }
    }
}
