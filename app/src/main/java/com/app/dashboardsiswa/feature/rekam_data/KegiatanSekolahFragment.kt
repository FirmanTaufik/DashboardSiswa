package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentKegiatanSekolahBinding

class KegiatanSekolahFragment : Fragment() {

    lateinit var binding :FragmentKegiatanSekolahBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKegiatanSekolahBinding.inflate(layoutInflater)
        return binding.root
    }

}