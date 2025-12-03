package com.bianca.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // BACK BUTTON
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // TEXT FIELDS
        val tvKontak = findViewById<TextView>(R.id.tvKontak)
        val tvInstagram = findViewById<TextView>(R.id.tvInstagram)
        val tvGithub = findViewById<TextView>(R.id.tvGithub)

        // OPTIONAL: Jika ingin diisi dari Kotlin (bisa dihapus kalau pakai XML)
        tvKontak.text = "0812-3456-7890"
        tvInstagram.text = "pluviophiell"
        tvGithub.text = "github.com/bianca3020"

        // PROFILE IMAGE
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        profileImage.setImageResource(R.drawable.giselle_icon)
    }
}
