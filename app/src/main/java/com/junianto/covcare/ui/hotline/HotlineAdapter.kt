package com.junianto.covcare.ui.hotline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.junianto.covcare.R
import com.junianto.covcare.databinding.ItemContactBinding
import com.junianto.covcare.model.contact.Contact

class HotlineAdapter(val contactList: ArrayList<Contact>): RecyclerView.Adapter<HotlineAdapter.HotlineViewHolder>() {
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): HotlineViewHolder {
        return HotlineViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: HotlineViewHolder, position: Int) {
        contactList[position].let { holder.bind(it) }
    }

    class HotlineViewHolder (private val contactBinding: ItemContactBinding): RecyclerView.ViewHolder(contactBinding.root) {
        fun bind(contact: Contact) {
            contactBinding.contact = contact
            contactBinding.executePendingBindings()
        }
    }
}