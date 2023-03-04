package com.app.dashboardsiswa.feature.satgas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentSatgasQRBinding


class SatgasQRFragment : Fragment() {

    lateinit var binding :FragmentSatgasQRBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSatgasQRBinding.inflate(layoutInflater)
        return binding.root
    }

}