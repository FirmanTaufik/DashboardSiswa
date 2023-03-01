package com.app.dashboardsiswa.activity

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.app.dashboardsiswa.R
import com.app.dashboardsiswa.databinding.ActivityMainBinding
import com.app.dashboardsiswa.databinding.HeaderMenuBinding
import com.app.dashboardsiswa.feature.agenda.AgendaFragment
import com.app.dashboardsiswa.feature.daftar_ulang.DaftarUlangFragment
import com.app.dashboardsiswa.feature.dashboard.DashboardFragment
import com.app.dashboardsiswa.feature.perpustakaan.PerpustakaanFragment
import com.app.dashboardsiswa.feature.profile.ProfileFragment
import com.app.dashboardsiswa.feature.rekam_data.*
import com.app.dashboardsiswa.feature.satgas.*
import com.app.dashboardsiswa.feature.ukgs.UkgsFragment
import com.app.dashboardsiswa.helper.Utils


class MainActivity : AppCompatActivity(), OnClickListener {
    val TAG = "MainActivityTAG"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.bringToFront()
        initHeader()
        setContentFragment( DashboardFragment())

    }

   lateinit var header :HeaderMenuBinding
    private fun initHeader() {
        val view = LayoutInflater.from(applicationContext)
        header = HeaderMenuBinding.inflate(view, null, false)
        binding.navView.addView(header.root)
        header.linearWrap.forEach {
            it.setOnClickListener(this)
        }

    }

    override fun onClick(p0: View) {
        Log.d(TAG, "onClick: " + p0.id)
        when (p0.id) {
            R.id.dasboard -> setContentFragment( DashboardFragment())
            R.id.profile -> setContentFragment( ProfileFragment())
            R.id.agenda -> setContentFragment( AgendaFragment())
            R.id.rekam -> {
                if (header.expandableLayout1.isExpanded)
                    header.expandableLayout1.collapse(true)
                else header.expandableLayout1.expand(true)
                 header.linearSub1[0].setOnClickListener {
                     setContentFragment( EkstrakurikulerFragment())
                 }
                header.linearSub1[1].setOnClickListener {
                    setContentFragment( PengembanganKerohanianFragment())
                }
                header.linearSub1[2].setOnClickListener {
                    setContentFragment( PengembanganKarakterFragment())
                }
                header.linearSub1[3].setOnClickListener {
                    setContentFragment( KegiatanKemasyarakatanFragment())
                }
                header.linearSub1[4].setOnClickListener {
                    setContentFragment( KegiatanSekolahFragment())
                }
                header.linearSub1[5].setOnClickListener {
                    setContentFragment( KepengurusanFragment())
                }
                header.linearSub1[6].setOnClickListener {
                    setContentFragment( PrestasiFragment())
                }
                header.linearSub1[7].setOnClickListener {
                    setContentFragment( ProyekFragment())
                }
                header.linearSub1[8].setOnClickListener {
                    setContentFragment( KegiatanSekolahFragment())
                }
                header.linearSub1[9].setOnClickListener {
                    setContentFragment( RekapitulasiFragment())
                }
            }
            R.id.perpustakaan -> setContentFragment( PerpustakaanFragment())
            R.id.satgas -> {
                if (header.expandableLayout2.isExpanded)
                    header.expandableLayout2.collapse(true)
                else header.expandableLayout2.expand(true)

                header.linearSub2[0].setOnClickListener {
                    setContentFragment( SatgasDashboardFragment())
                }
                header.linearSub2[1].setOnClickListener {
                    setContentFragment( SatgastTestFragment())
                }
                header.linearSub2[2].setOnClickListener {
                    setContentFragment( SatgasVaksinasiFragment())
                }
                header.linearSub2[3].setOnClickListener {
                    setContentFragment( SatgasQRFragment())
                }
                header.linearSub2[4].setOnClickListener {
                    setContentFragment( PersiapanPendataanVaksinFragment())
                }
            }
            R.id.daftar -> setContentFragment( DaftarUlangFragment())
            R.id.ukgs -> setContentFragment( UkgsFragment())
        }


    }

    private fun setContentFragment(fragment: Fragment ) {
        supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
        binding.drawerLayout.closeDrawer(GravityCompat.START, true)
    }
}