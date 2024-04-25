package com.dicoding.myappsubmission

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.myappsubmission.ListMakananAdapter.Companion.EXTRA_DESCRIPTION
import com.dicoding.myappsubmission.ListMakananAdapter.Companion.EXTRA_NAME

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDescription = findViewById<TextView>(R.id.tv_detail_description)

        tvName.text = intent.getStringExtra(EXTRA_NAME)
        tvDescription.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }
}