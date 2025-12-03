package com.bianca.myapplication

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class KonversiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konversi)

        // ==== BACK BUTTON ====
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Views
        val inputNumber = findViewById<EditText>(R.id.inputNumber)
        val spinnerFrom = findViewById<Spinner>(R.id.spinnerFrom)
        val spinnerTo = findViewById<Spinner>(R.id.spinnerTo)
        val btnConvert = findViewById<Button>(R.id.btnConvert)

        val cardResult = findViewById<View>(R.id.cardResult)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Spinner options
        val units = arrayOf("Celsius", "Fahrenheit", "Kelvin", "Reamur")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            units
        )

        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        // Convert button
        btnConvert.setOnClickListener {
            val value = inputNumber.text.toString()

            if (value.isBlank()) {
                Toast.makeText(this, "Masukkan nilai suhu.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val input = value.toDoubleOrNull()
            if (input == null) {
                Toast.makeText(this, "Input tidak valid.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val from = spinnerFrom.selectedItem.toString()
            val to = spinnerTo.selectedItem.toString()

            if (from == to) {
                tvResult.text = "Nilai tidak berubah (unit sama)"
                cardResult.visibility = View.VISIBLE
                return@setOnClickListener
            }

            val result = convertTemperature(input, from, to)
            val rounded = String.format("%.2f", result)

            tvResult.text = "$input $from → $rounded $to"

            // Fade in animation
            val fadeIn = AlphaAnimation(0f, 1f).apply {
                duration = 350
            }

            cardResult.startAnimation(fadeIn)
            cardResult.visibility = View.VISIBLE
        }
    }

    // Conversion Function
    private fun convertTemperature(value: Double, from: String, to: String): Double {

        // Convert to Celsius
        val celsius = when (from) {
            "Celsius" -> value
            "Fahrenheit" -> (value - 32) * 5 / 9
            "Kelvin" -> value - 273.15
            "Reamur" -> value / 0.8
            else -> value
        }

        // Convert from Celsius to target
        return when (to) {
            "Celsius" -> celsius
            "Fahrenheit" -> celsius * 9 / 5 + 32
            "Kelvin" -> celsius + 273.15
            "Reamur" -> celsius * 0.8
            else -> celsius
        }
    }
}
