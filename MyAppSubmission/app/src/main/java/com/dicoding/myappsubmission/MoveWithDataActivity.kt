package com.dicoding.myappsubmission

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.myappsubmission.ListMakananAdapter.Companion.EXTRA_DESCRIPTION
import com.dicoding.myappsubmission.ListMakananAdapter.Companion.EXTRA_NAME
import com.dicoding.myappsubmission.ListMakananAdapter.Companion.EXTRA_PHOTO

class MoveWithDataActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move_with_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        // Mendapatkan data yang diterima dari intent
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        // Menampilkan data pada TextView
        val textToShow = "Name: $name\nDescription: $description"
        tvDataReceived.text = textToShow
    }
}