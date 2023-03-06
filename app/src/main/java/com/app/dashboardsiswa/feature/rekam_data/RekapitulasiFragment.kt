package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentRekapitulasiBinding
import com.app.dashboardsiswa.databinding.TabelContentBinding
import com.app.dashboardsiswa.helper.Utils

class RekapitulasiFragment : Fragment() {

    lateinit var binding:FragmentRekapitulasiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentRekapitulasiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layout = TabelContentBinding.inflate(LayoutInflater.from(context) )

        val params = layout.text1.getLayoutParams()
        params.width =  getResources().getDimension(R.dimen.size_200).toInt()
        params.height =ViewGroup.LayoutParams.WRAP_CONTENT
        layout.text1.layoutParams = params

        layout.text1.text = "Tahun"
        layout.text2.text = "Nama Kegiatan"
        layout.text3.text = "Deskripsi Kegiatan"
        layout.text4.text = "Peran Siswa"
        layout.text5.visibility=View.VISIBLE
        layout.text5.text = "Tanggal Kegiatan"

        binding.tableLayout.addView(layout.root)
        for (i in 0 until 15){
            val content = TabelContentBinding.inflate(LayoutInflater.from(context) )
            content.text1.layoutParams = params
            content.text1.text = "Tahun" +i.toString()
            content.text2.text = "Nama Kegiatan" +i.toString()
            content.text3.text = "Deskripsi Kegiatan" +i.toString()
            content.text4.text = "Peran Siswa" +i.toString()
            content.text5.visibility=View.VISIBLE
            content.text5.text = "Tanggal Kegiatan" +i.toString()
            binding.tableLayout.addView(content.root)

        }
        super.onViewCreated(view, savedInstanceState)
    }
}