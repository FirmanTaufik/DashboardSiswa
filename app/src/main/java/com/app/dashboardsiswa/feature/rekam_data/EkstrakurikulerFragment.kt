package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.DialogAddEkstrakurikuleBinding
import com.app.dashboardsiswa.databinding.FragmentEkstrakurikulerBinding
import com.app.dashboardsiswa.databinding.TabelContentBinding
import com.app.dashboardsiswa.helper.Utils

class EkstrakurikulerFragment : Fragment() {

    lateinit var binding :FragmentEkstrakurikulerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEkstrakurikulerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initOnClick()
        initTable()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initTable() {

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
    }

    private fun initOnClick() {
        binding.btn.setOnClickListener {
            dialogAdd()
        }
    }

    private fun dialogAdd() {
        val dialog = DialogAddEkstrakurikuleBinding.inflate(layoutInflater)

        val itemsKegiatan = listOf("Catur", "Choir", "Coding", "Design Grafis", "Manga", "Math Club", "Melukis"
            , "Modern Dance", "Pramuka", "Science Club" )
        dialog.autoKegiatan.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, itemsKegiatan))

        val itemsJadwal = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" )
        dialog.autoJadwal.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, itemsJadwal))

        Utils.setCustomDialog(requireContext(), dialog.root,null, object :Utils.Callback{
            override fun onPositive() {
                Utils.showToastInfo(requireContext(), "yes")
            }

            override fun onNegative() {
                Utils.showToastInfo(requireContext(), "No")

            }

        })
    }
}