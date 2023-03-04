package com.app.dashboardsiswa.feature.satgas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentSatgasDashboardBinding

class SatgasDashboardFragment : Fragment() {

    lateinit var binding :FragmentSatgasDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSatgasDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

}