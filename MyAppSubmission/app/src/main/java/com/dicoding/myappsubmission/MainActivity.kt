package com.dicoding.myappsubmission

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMakanan: RecyclerView
    private val list = ArrayList<Makanan>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvMakanan = findViewById(R.id.rv_makanan)
        rvMakanan.setHasFixedSize(true)

        list.addAll(getListMakanan())
        showRecyclerList()
        MoveWithDataActivity()
        DetailActivity()
    }

    @SuppressLint("Recycle")
    private fun getListMakanan(): ArrayList<Makanan> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMakanan = ArrayList<Makanan>()
        for (i in dataName.indices) {
            val makanan = Makanan(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMakanan.add(makanan)
        }
        return listMakanan
    }
    private fun showRecyclerList() {
        rvMakanan.layoutManager = LinearLayoutManager(this)
        val listMakananAdapter = ListMakananAdapter(list)
        rvMakanan.adapter = listMakananAdapter

        listMakananAdapter.setOnItemClickCallback(object : ListMakananAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Makanan) {
                showSelectedMakanan(data)
            }
        })
    }

    private fun showSelectedMakanan(makanan: Makanan) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("nama_makanan", makanan.name)
            putExtra("deskripsi_makanan", makanan.description)
            putExtra("gambar_makanan", makanan.photo)
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
        //klo bisa mau kuganti jadi garis 3 horizontal ada menu login & penempatan list/grid
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvMakanan.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvMakanan.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}