package com.app.dashboardsiswa.feature.agenda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.core.view.updateLayoutParams
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.FragmentAgendaBinding
import com.app.dashboardsiswa.databinding.TabelContentBinding

class AgendaFragment : Fragment() {

    val TAG ="AgendaFragmentTAG"
    lateinit var binding  : FragmentAgendaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgendaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layout = TabelContentBinding.inflate(LayoutInflater.from(context) )
        layout.text1.text = "#"
        layout.text2.text = "Date"
        layout.text3.text = "Title"
        layout.text4.text = "Agenda"

        binding.tableLayout.addView(layout.root)
        for (i in 0 until 15){
            val content = TabelContentBinding.inflate(LayoutInflater.from(context) )
            content.text1.text = i.toString()
            content.text2.text = "Date"+ i.toString()
            content.text3.text = "Title"+ i.toString()
            content.text4.text = "Agenda"+ i.toString()
            binding.tableLayout.addView(content.root)

        }
        super.onViewCreated(view, savedInstanceState)
    }


}