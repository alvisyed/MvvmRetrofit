package com.dynamicdev.coronainfoapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dynamicdev.coronainfoapp.databinding.CovidItemLayoutBinding
import com.dynamicdev.coronainfoapp.model.data.Country

class CovidListAdapter: RecyclerView.Adapter<CovidListAdapter.CovidListViewHolder>() {

var listCovid = listOf<Country>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    inner class CovidListViewHolder(val binding: CovidItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidListViewHolder {
       val binding= CovidItemLayoutBinding.inflate(LayoutInflater.from(
           parent.context),
            parent,
            false)
        return CovidListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CovidListViewHolder, position: Int) {
        holder.binding.txtCountryName.text=listCovid[position].Country
        holder.binding.txtConfirmCases.text=listCovid[position].TotalConfirmed.toString()
        holder.binding.txtRecovered.text=listCovid[position].TotalRecovered.toString()
        holder.binding.txtTotalDeaths.text=listCovid[position].TotalDeaths.toString()
    }

    override fun getItemCount(): Int {
        return listCovid.size
    }
}