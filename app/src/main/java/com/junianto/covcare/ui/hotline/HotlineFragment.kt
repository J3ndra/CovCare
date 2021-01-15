package com.junianto.covcare.ui.hotline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.junianto.covcare.R
import com.junianto.covcare.databinding.FragmentHotlineBinding
import com.junianto.covcare.model.contact.Contact
import com.junianto.covcare.model.contact.ContactData
import kotlinx.android.synthetic.main.fragment_hotline.*

class HotlineFragment : Fragment() {

    private lateinit var binding: FragmentHotlineBinding
    private lateinit var hotlineAdapter: HotlineAdapter

    private var list: ArrayList<Contact> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hotline, container, false)

        list.addAll(ContactData.listContact)
        hotlineAdapter = HotlineAdapter(list)
        binding.rvContact.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = hotlineAdapter
            setHasFixedSize(true)
        }

        return binding.root
    }
}