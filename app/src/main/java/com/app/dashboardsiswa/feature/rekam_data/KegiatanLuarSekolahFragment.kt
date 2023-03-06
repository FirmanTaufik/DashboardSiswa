package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentKegiatanLuarSekolahBinding
import com.app.dashboardsiswa.databinding.TabelContentBinding


class KegiatanLuarSekolahFragment : Fragment() {

    lateinit var binding :FragmentKegiatanLuarSekolahBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKegiatanLuarSekolahBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layout = TabelContentBinding.inflate(LayoutInflater.from(context) )

        val params = layout.text1.getLayoutParams()
        params.width =  getResources().getDimension(R.dimen.size_200).toInt()
        params.height =ViewGroup.LayoutParams.WRAP_CONTENT
        layout.text1.layoutParams = params

        layout.text1.text = "Nama Kegiatan"
        layout.text2.text = "Jadwal"
        layout.text3.text = "Status"
        layout.text4.text = "Detail"

        binding.tableLayout.addView(layout.root)
        for (i in 0 until 15){
            val content = TabelContentBinding.inflate(LayoutInflater.from(context) )
            content.text1.layoutParams = params
            content.text1.text =  "Nama Kegiatan" +i.toString()
            content.text2.text = "Jadwal"+ i.toString()
            content.text3.text = "Status"+ i.toString()
            content.text4.text = "Detail"+ i.toString()
            binding.tableLayout.addView(content.root)

        }
        super.onViewCreated(view, savedInstanceState)
    }
}