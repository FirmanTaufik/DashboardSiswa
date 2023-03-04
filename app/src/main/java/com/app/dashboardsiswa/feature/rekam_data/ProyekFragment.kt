package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentProyekBinding


class ProyekFragment : Fragment() {

    lateinit var binding:FragmentProyekBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProyekBinding.inflate(layoutInflater)
        return binding.root
    }

}