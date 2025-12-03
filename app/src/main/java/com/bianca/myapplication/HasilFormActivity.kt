package com.bianca.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HasilFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_form)

        // Ambil view dari XML
        val tvNama = findViewById<TextView>(R.id.NamA)
        val tvNomor = findViewById<TextView>(R.id.Nomerr)
        val tvAlamat = findViewById<TextView>(R.id.etAlamatt)
        val tvKelamin = findViewById<TextView>(R.id.tvKelamin)
        val tvAgama = findViewById<TextView>(R.id.tvAgama)
        val tvHobi = findViewById<TextView>(R.id.tvHobi)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        // Ambil data dari Intent
        val nama = intent.getStringExtra("nama")
        val nomor = intent.getStringExtra("nomor")
        val alamat = intent.getStringExtra("alamat")
        val gender = intent.getStringExtra("jenisKelamin")
        val agama = intent.getStringExtra("agama")
        val hobi = intent.getStringExtra("hobi")

        // Tampilkan ke TextView
        tvNama.text = "Nama: $nama"
        tvNomor.text = "Nomor: $nomor"
        tvAlamat.text = "Alamat: $alamat"
        tvKelamin.text = "Jenis Kelamin: $gender"
        tvAgama.text = "Agama: $agama"
        tvHobi.text = "Hobi: $hobi"

        btnKembali.setOnClickListener {
            finish()
        }
    }
}
