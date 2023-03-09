package com.app.dashboardsiswa.feature.satgas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentSatgasVaksinasiBinding
import com.app.dashboardsiswa.helper.Utils


class SatgasVaksinasiFragment : Fragment() {

    lateinit var binding :FragmentSatgasVaksinasiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentSatgasVaksinasiBinding.inflate(layoutInflater)
        initLayoutVaksin1()
        initLayoutVaksin2()
        initLayoutVaksin3()
        return binding.root
    }

    private fun initLayoutVaksin1() {
        binding.vaksin1.setOnClickListener {
            if (binding.expandableLayout1.isExpanded)
                binding.expandableLayout1.collapse(true)
            else binding.expandableLayout1.expand(true)
        }
    }
    private fun initLayoutVaksin2() {
        binding.vaksin2.setOnClickListener {
            if (binding.expandableLayout2.isExpanded)
                binding.expandableLayout2.collapse(true)
            else binding.expandableLayout2.expand(true)
        }
    }
    private fun initLayoutVaksin3() {
        binding.vaksin3.setOnClickListener {
            if (binding.expandableLayout3.isExpanded)
                binding.expandableLayout3.collapse(true)
            else binding.expandableLayout3.expand(true)
        }
    }
}