package com.surelabsid.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.surelabsid.inventory.databinding.ActivityMainBinding

class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //kasih action klik
        binding.tambahBarang.setOnClickListener {
            Intent(this@MainMenuActivity, MainTambahBarangActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}