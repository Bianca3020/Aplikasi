package com.bianca.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        // Apply system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ================ GET VIEW FROM XML ================
        val btnFormulir = findViewById<LinearLayout>(R.id.btnFormulir)
        val btnProfile = findViewById<LinearLayout>(R.id.btnProfile)
        val btnBakery = findViewById<LinearLayout>(R.id.btnBakery)
        val btnCalculator = findViewById<LinearLayout>(R.id.btnCalculator)
        val btnKonversi = findViewById<LinearLayout>(R.id.btnKonversi)
        val btnExit = findViewById<LinearLayout>(R.id.btnExit)

        // ================ BUTTON ACTIONS ==================

        // GO TO FORM PAGE
        btnFormulir.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

        // GO TO PROFILE PAGE
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // KALKULATOR
        btnCalculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }

        // BAKERY
        btnBakery.setOnClickListener {
            startActivity(Intent(this, BakeryActivity::class.java))
        }


        // KONVERSI SUHU
        btnKonversi.setOnClickListener {
            startActivity(Intent(this, KonversiActivity::class.java))
        }

        // EXIT APP
        btnExit.setOnClickListener {
            showExitDialog()
        }

    }

    private fun showExitDialog() {
        val dialogView = layoutInflater.inflate(R.layout.activity_exit, null)
        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        // pastikan tipe view sesuai layout exit (Button)
        val btnYes = dialogView.findViewById<Button>(R.id.btnYes)
        val btnNo = dialogView.findViewById<Button>(R.id.btnNo)

        btnYes.setOnClickListener {
            finishAffinity()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
