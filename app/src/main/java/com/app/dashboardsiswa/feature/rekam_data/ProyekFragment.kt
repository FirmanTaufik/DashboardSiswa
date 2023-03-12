package com.app.dashboardsiswa.feature.rekam_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.DialogAddPrestasiBinding
import com.app.dashboardsiswa.databinding.DialogAddProyekBinding
import com.app.dashboardsiswa.databinding.FragmentProyekBinding
import com.app.dashboardsiswa.databinding.TabelContentBinding
import com.app.dashboardsiswa.helper.Utils
import org.jsoup.Jsoup


class ProyekFragment : Fragment() {

    lateinit var binding:FragmentProyekBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProyekBinding.inflate(layoutInflater)
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
        val dialog = DialogAddProyekBinding.inflate(layoutInflater)

        dialog.autoGuruPendamping1.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, getGuru()))
        dialog.autoGuruPendamping2.setAdapter(ArrayAdapter(requireContext(), R.layout.dropdown_item, getGuru()))

        Utils.setCustomDialog(requireContext(), dialog.root,null, object : Utils.Callback{
            override fun onPositive() {
                Utils.showToastInfo(requireContext(), "yes")
            }

            override fun onNegative() {
                Utils.showToastInfo(requireContext(), "No")

            }

        })
    }

    fun getGuru():  List<String> {
        val iList = ArrayList<String>()
        val html = "<select required=\"\" name=\"pembimbing1\">\n" +
                "<option value=\"\"></option>\n" +
                "<option value=\"0100086\">DEWI W YONATAN</option>\n" +
                "<option value=\"0102027\">DWI YANTI WIDIANINGSIH</option>\n" +
                "<option value=\"0104167\">TENDO ARIVYANTO</option>\n" +
                "<option value=\"0106067\">ARNITA NATALINA</option>\n" +
                "<option value=\"0106143\">SAN SAN</option>\n" +
                "<option value=\"0106209\">NURSALAM PARDEDE</option>\n" +
                "<option value=\"0107004\">DENY VERANITA</option>\n" +
                "<option value=\"0107008\">RATNO</option>\n" +
                "<option value=\"0107092\">SYLVANA MARGARETHA</option>\n" +
                "<option value=\"0107142\">DWI KRISTANTI</option>\n" +
                "<option value=\"0108083\">EKA PUSPITA K</option>\n" +
                "<option value=\"0111086\">AMRITA KRISTIANI</option>\n" +
                "<option value=\"0111110\">BURIANTO SIMATUPANG</option>\n" +
                "<option value=\"0111204\">JUJU HENRY P</option>\n" +
                "<option value=\"0112005\">MEIKE CAMELIA</option>\n" +
                "<option value=\"0112029\">RINA</option>\n" +
                "<option value=\"0112034\">WIRDA INDRIANY</option>\n" +
                "<option value=\"0112038\">ANDREAS KANGIRAS</option>\n" +
                "<option value=\"0112151\">MARIANI</option>\n" +
                "<option value=\"0112215\">NERDINIA UMBU ANDI</option>\n" +
                "<option value=\"0112277\">SIMON GIFSUN ARITONANG</option>\n" +
                "<option value=\"0113055\">FEBY PARAMITHA</option>\n" +
                "<option value=\"0113201\">ALEXANDER DAUD TAMBUNAN</option>\n" +
                "<option value=\"0113360\">FELICIA</option>\n" +
                "<option value=\"0114005\">MARYANNA</option>\n" +
                "<option value=\"0114071\">PETRUS IWAN DWI PURNOMO</option>\n" +
                "<option value=\"0114140\">MARGARETA ERNA WIJAYANTI</option>\n" +
                "<option value=\"0114148\">SABET</option>\n" +
                "<option value=\"0115049\">DAVID BADIARAJA SIHOMBING</option>\n" +
                "<option value=\"0115051\">REBECCA RISKA ANGKOUW</option>\n" +
                "<option value=\"0115150\">YULIA WULANDARU</option>\n" +
                "<option value=\"0116013\">MICHAEL SALAMA</option>\n" +
                "<option value=\"0116148\">SILVA DEMAK</option>\n" +
                "<option value=\"0116181\">CHANDRA JIWA PRAJA</option>\n" +
                "<option value=\"0116186\">MAGDALENA IRIN</option>\n" +
                "<option value=\"0117081\">ANSELMUS APRI HARIADI</option>\n" +
                "<option value=\"0118080\">GREGORIA NAZIANZYA YANU KUNDHY ARDHINA</option>\n" +
                "<option value=\"0118185\">YUDI LINTANG PERMANA</option>\n" +
                "<option value=\"0118201\">WELNI JULITRA DAMANIK</option>\n" +
                "<option value=\"0119056\">MATIAS LEOVINUS</option>\n" +
                "<option value=\"0119077\">PRISKA YEKTI MITAYANI</option>\n" +
                "<option value=\"0119098\">MONICA</option>\n" +
                "<option value=\"0119099\">WAHYU BANGKIT PRASTOWO</option>\n" +
                "<option value=\"0119105\">ANASTASIA DEVINA CICILIA</option>\n" +
                "<option value=\"0119127\">TESSALONIKA SITORUS</option>\n" +
                "<option value=\"0120080\">NATHANIA TRI ASIH PATTIASINA</option>\n" +
                "<option value=\"0121064\">ABIGAEL ADE DAMAYANTI</option>\n" +
                "<option value=\"0121065\">LILIS SURYANI SIMANJUNTAK</option>\n" +
                "<option value=\"0121066\">HYACHINTA SHARON</option>\n" +
                "<option value=\"0121071\">MIKEL EFENDI SITOHANG</option>\n" +
                "<option value=\"0121077\">KRIS PANGGRAITA</option>\n" +
                "<option value=\"0192024\">CICILIA RUMIYATI</option>\n" +
                "<option value=\"0194003\">LINDA SINTAWATI MANURUNG</option>\n" +
                "<option value=\"0194025\">RIANA MANALU</option>\n" +
                "<option value=\"0194030\">EFA HANANI</option>\n" +
                "<option value=\"0196101\">SARWONO</option>\n" +
                "<option value=\"0196119\">PARYATI</option>\n" +
                "<option value=\"0199027\">F X SUNARTA</option>\n" +
                "<option value=\"TKL000060\">Bayu sandi asa</option>\n" +
                "<option value=\"TKL000064\">BUDI NUGROHO</option>\n" +
                "<option value=\"TKL000070\">Dadang Mulyadi</option>\n" +
                "<option value=\"TKL000151\">Meidina Ulfah</option>\n" +
                "<option value=\"TKL000173\">SAMUEL RAMLAN</option>\n" +
                "<option value=\"TKL000183\">Sumarni</option>\n" +
                "<option value=\"TKL000241\">SUGENG PRASETYO</option>\n" +
                "<option value=\"TKL000242\">M NOVIAN SIREGAR</option>\n" +
                "<option value=\"TKL000316\">MAKSUM FIRDAUS</option>\n" +
                "<option value=\"TKL000335\">RIAN KAPRIAGA</option>\n" +
                "<option value=\"TKL000336\">TETEN ZAINAL ABIDIN</option>\n" +
                "</select>"

        val doc = Jsoup.parse(html)
        val  element = doc.select("select").select("option")
        element.forEach {
            val value = it.text()
            iList.add(value)
        }
        return iList
    }
}