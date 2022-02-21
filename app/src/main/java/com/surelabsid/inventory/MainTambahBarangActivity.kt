package com.surelabsid.inventory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.surelabsid.inventory.adapter.AdapterBarang
import com.surelabsid.inventory.adapter.Barang
import com.surelabsid.inventory.databinding.ActivityMainTambahBarangBinding

class MainTambahBarangActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainTambahBarangBinding
    private lateinit var adapterBarang: AdapterBarang
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainTambahBarangBinding.inflate(layoutInflater)
        
        setContentView(binding.root)

        addJenisBarang()

        adapterBarang = AdapterBarang{
            Toast.makeText(this, it.barang, Toast.LENGTH_SHORT).show()
        }
        binding.rvBarang.apply {
            adapter = adapterBarang
            layoutManager = LinearLayoutManager(this@MainTambahBarangActivity)
        }

        binding.pilihGambar.setOnClickListener{
            val pickImage = Intent(Intent.ACTION_OPEN_DOCUMENT)
            pickImage.type = "image/*"
            startActivityForResult(Intent.createChooser(pickImage, null), 1000)
        }
        
        //kasih klik untuk tombol simpannya
        binding.simpanData.setOnClickListener { 
            //ambil inputan text edit text
            val namaBarang = binding.namaBarang.text.toString()
            val hargaBarang = binding.harga.text.toString()
            val jenisBarang = binding.dropdownJenisBarang.selectedItem.toString()

            val barangModel = Barang(barang = namaBarang, harga = hargaBarang, jenis = jenisBarang)
            val listBarangModel = mutableListOf<Barang>()
            listBarangModel.add(barangModel)

            adapterBarang.addItem(listBarangModel)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1000 && resultCode == Activity.RESULT_OK){
            data?.let {
                Log.d("Intent Result", "onActivityResult: $data")
            }
        }
    }

    fun addJenisBarang(){
        val jenis = mutableListOf("Elektronik", "Berkas")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, jenis)

        binding.dropdownJenisBarang.adapter = adapter
    }
}