package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.DialogAddEkstrakurikuleBinding
import com.app.dashboardsiswa.databinding.DialogAddKerohanianBinding
import com.app.dashboardsiswa.databinding.FragmentPengembanganKerohanianBinding
import com.app.dashboardsiswa.databinding.TabelContentBinding
import com.app.dashboardsiswa.helper.Utils


class PengembanganKerohanianFragment : Fragment() {

    lateinit var binding :FragmentPengembanganKerohanianBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPengembanganKerohanianBinding.inflate(layoutInflater)
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

        binding.btn.setOnClickListener {
            dialogAdd()
        }
        super.onViewCreated(view, savedInstanceState)
    }


    private fun dialogAdd() {
        val dialog = DialogAddKerohanianBinding.inflate(layoutInflater)
        val itemsKegiatan = listOf("Pelayanan Ke Gereja (Mengisi Pujian/choir)",
            "Pelayanan Kemasyarakatan (Bakti Sosial, Dokter Kecil)",
            "Pelayanan Kerohanian di sekolah (mengisi pujian/bertugas dalam ibadah sekolah)"  )
        dialog.autoKegiatan.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, itemsKegiatan))

        val itemsJadwal = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" )
        dialog.autoJadwal.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, itemsJadwal))

        Utils.setCustomDialog(requireContext(), dialog.root,null, object : Utils.Callback{
            override fun onPositive() {
                Utils.showToastInfo(requireContext(), "yes")
            }

            override fun onNegative() {
                Utils.showToastInfo(requireContext(), "No")

            }

        })
    }
}