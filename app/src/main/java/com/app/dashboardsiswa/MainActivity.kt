package com.app.dashboardsiswa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.core.view.get
import com.app.dashboardsiswa.databinding.ActivityMainBinding
import com.app.dashboardsiswa.databinding.HeaderMenuBinding
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
            R.id.dasboard -> Utils.showToastInfo(this, "dasboard")
            R.id.profile -> Utils.showToastInfo(this, "profile")
            R.id.agenda -> Utils.showToastInfo(this, "agenda")
            R.id.rekam -> {
                if (header.expandableLayout1.isExpanded)
                    header.expandableLayout1.collapse(true)
                else header.expandableLayout1.expand(true)
                 header.linearSub1[0].setOnClickListener {
                     Utils.showToastInfo(this, "rekam 1")
                 }
                header.linearSub1[1].setOnClickListener {
                    Utils.showToastInfo(this, "rekam 2")
                }
            }
            R.id.perpustakaan -> Utils.showToastInfo(this, "perpustakaan")
            R.id.satgas -> {
                if (header.expandableLayout2.isExpanded)
                    header.expandableLayout2.collapse(true)
                else header.expandableLayout2.expand(true)
            }
            R.id.daftar -> Utils.showToastInfo(this, "daftar")
            R.id.ukgs -> Utils.showToastInfo(this, "ukgs")
        }
    }
}