package com.app.dashboardsiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.dashboardsiswa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}