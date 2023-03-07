package com.app.dashboardsiswa.feature.satgas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentSatgasDashboardBinding
import com.app.dashboardsiswa.databinding.TabelContent2Binding
import com.app.dashboardsiswa.databinding.TabelContentBinding

class SatgasDashboardFragment : Fragment() {

    lateinit var binding :FragmentSatgasDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSatgasDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layout = TabelContent2Binding.inflate(LayoutInflater.from(context) )
        layout.text1.text = "Nama"
        layout.text2.text = "Tanggal Test"
        layout.text3.text = "Tanggal Masuk"
        layout.text4.text = "Score"
        layout.text5.text = "Approval"
        layout.text6.text = "Tanggal Approvalk"
        layout.text7.text = "Scan Masuk"
        layout.text8.text = "Scan Pulang"
        layout.text9.text = "QR"
        layout.text10.text = "Check out"

        binding.tableLayout.addView(layout.root)
        for (i in 0 until 15){
            val content = TabelContent2Binding.inflate(LayoutInflater.from(context) )
            content.text1.text =  "Lawrencia Timothy Wijaya" +i.toString()
            content.text2.text = "2022-05-23 07:05:16"+ i.toString()
            content.text3.text = "2022-05-23"+ i.toString()
            content.text4.text = "0"+ i.toString()
            content.text5.text = "Lolos"
            content.text6.text = "2022-05-23 07:05:16"
            content.text7.text = ""
            content.text8.text = ""
            content.text9.setCompoundDrawablesWithIntrinsicBounds(requireActivity().resources.getDrawable(R.drawable.baseline_settings_24),null, null,null)
            content.text10.text = ""
            binding.tableLayout.addView(content.root)

        }
        super.onViewCreated(view, savedInstanceState)
    }
}