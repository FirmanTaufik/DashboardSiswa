package com.app.dashboardsiswa.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding :FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        initDataSiswa()
        initAlamat()
        initKeteranganLainya()
        return binding.root
    }

    private fun initKeteranganLainya() {
        binding.linearKeteranganLainya.setOnClickListener {
            if (binding.expandableLayout3.isExpanded)
                binding.expandableLayout3.collapse(true)
            else binding.expandableLayout3.expand(true)
        }
    }

    private fun initAlamat() {
        binding.linearAlamatTempat.setOnClickListener {
            if (binding.expandableLayout2.isExpanded)
                binding.expandableLayout2.collapse(true)
            else binding.expandableLayout2.expand(true)
        }
    }

    private fun initDataSiswa() {
        binding.linearDataSiswa.setOnClickListener {
            if (binding.expandableLayout1.isExpanded)
                binding.expandableLayout1.collapse(true)
            else binding.expandableLayout1.expand(true)
        }
        val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, items)
        binding.materialSpinner.setAdapter(adapter)
    }

}