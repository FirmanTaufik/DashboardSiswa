package com.app.dashboardsiswa.feature.ukgs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentUkgsBinding

class UkgsFragment : Fragment() {

    lateinit var binding :FragmentUkgsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUkgsBinding.inflate(layoutInflater)
        return binding.root
    }

}