package com.surelabsid.inventory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surelabsid.inventory.databinding.ItemAdapterBarangBinding

class AdapterBarang : RecyclerView.Adapter<AdapterBarang.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemAdapterBarangBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(barang: Barang) {
            binding.namaBarang.text = barang.barang
            binding.harga.text = barang.harga
            binding.jenis.text = barang.jenis
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAdapterBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listBarang.get(position))
    }

    override fun getItemCount(): Int {
        return listBarang.size
    }

    private var listBarang = mutableListOf<Barang>()

    fun addItem(list: MutableList<Barang>, clearAll: Boolean = false) {
        if (clearAll)
            listBarang.removeAll(listBarang)

        listBarang.addAll(list)

        notifyItemInserted(listBarang.size)
    }

}

data class Barang(
    val barang: String? = null,
    val harga: String? = null,
    val jenis: String? = null
)
