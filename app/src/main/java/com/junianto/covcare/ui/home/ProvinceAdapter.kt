package com.junianto.covcare.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.junianto.covcare.R
import com.junianto.covcare.databinding.ItemProvinceBinding
import com.junianto.covcare.model.ProvinceData

class ProvinceAdapter(val provinceList: List<ProvinceData>): RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProvinceViewHolder {
        return ProvinceViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_province, parent, false))
    }

    override fun getItemCount(): Int = provinceList.size

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        provinceList[position].let { holder.bind(it) }
    }

    class ProvinceViewHolder (private val provinceBinding: ItemProvinceBinding): RecyclerView.ViewHolder(provinceBinding.root) {
        fun bind(province: ProvinceData) {
            provinceBinding.province = province
            provinceBinding.executePendingBindings()
        }
    }
}