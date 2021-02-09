package com.percobaan.mysprgames

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.percobaan.mysprgames.databinding.ActivityMenuBinding



class MenuActivity: AppCompatActivity() {
    private var binding: ActivityMenuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
            
            val name : String = readLine()!!
            Snackbar.make(binding!!.root,"Selamat Datang $name",Snackbar.LENGTH_SHORT).setAction("Tutup") {
            }.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE).show()
        }

    }