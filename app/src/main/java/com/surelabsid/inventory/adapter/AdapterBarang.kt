package com.surelabsid.inventory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surelabsid.inventory.databinding.ItemAdapterBarangBinding

class AdapterBarang(private val clickItem: (Barang) -> Unit) : RecyclerView.Adapter<AdapterBarang.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemAdapterBarangBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(barang: Barang) {
            binding.namaBarang.text = barang.barang
            binding.harga.text = barang.harga
            binding.jenis.text = barang.jenis


            //inti klik untuk masing-masing baris ke recyclerview nya
            binding.root.setOnClickListener{
                clickItem(barang)
            }
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

        notifyDataSetChanged()
    }

}

data class Barang(
    val barang: String? = null,
    val harga: String? = null,
    val jenis: String? = null
)
