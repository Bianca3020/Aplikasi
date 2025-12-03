package com.bianca.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etNomor: EditText
    private lateinit var etAlamat: EditText
    private lateinit var sAgama: Spinner
    private lateinit var rdgJenisKelamin: RadioGroup
    private lateinit var cbMembaca: CheckBox
    private lateinit var cbMakan: CheckBox
    private lateinit var cbTidur: CheckBox
    private lateinit var cbMusik: CheckBox
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        // BACK BUTTON
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // === INISIALISASI VIEW ===
        etNama = findViewById(R.id.etNama)
        etNomor = findViewById(R.id.etNomor)
        etAlamat = findViewById(R.id.etAlamat)
        sAgama = findViewById(R.id.sAgama)
        rdgJenisKelamin = findViewById(R.id.rdgJenisKelamin)
        cbMembaca = findViewById(R.id.cbMembaca)
        cbMakan = findViewById(R.id.cbMakan)
        cbTidur = findViewById(R.id.cbTidur)
        cbMusik = findViewById(R.id.cbMusik)
        btnSimpan = findViewById(R.id.btSimpan)

        // === AKSI TOMBOL SIMPAN ===
        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val nomor = etNomor.text.toString()
            val alamat = etAlamat.text.toString()
            val agama = sAgama.selectedItem.toString()

            // Gender
            val selectedGenderId = rdgJenisKelamin.checkedRadioButtonId
            val jenisKelamin = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Belum memilih"
            }

            // Hobi
            val hobiList = ArrayList<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbMakan.isChecked) hobiList.add("Makan")
            if (cbTidur.isChecked) hobiList.add("Tidur")
            if (cbMusik.isChecked) hobiList.add("Mendengarkan Musik")

            val hobi = if (hobiList.isEmpty()) "Tidak ada hobi" else hobiList.joinToString(", ")

            // === KIRIM DATA KE HASIL FORM ===
            val intent = Intent(this, HasilFormActivity::class.java)

            intent.putExtra("nama", nama)
            intent.putExtra("nomor", nomor)
            intent.putExtra("alamat", alamat)
            intent.putExtra("agama", agama)
            intent.putExtra("jenisKelamin", jenisKelamin)
            intent.putExtra("hobi", hobi)

            startActivity(intent)
        }

    }
}

