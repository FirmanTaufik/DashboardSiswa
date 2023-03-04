package com.app.dashboardsiswa.feature.perpustakaan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentPerpustakaanBinding

class PerpustakaanFragment : Fragment() {
   lateinit var binding :FragmentPerpustakaanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerpustakaanBinding.inflate(layoutInflater)
        return binding.root
    }
}