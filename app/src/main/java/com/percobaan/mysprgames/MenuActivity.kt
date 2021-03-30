package com.percobaan.mysprgames

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.percobaan.mysprgames.databinding.ActivityMenuBinding


@Suppress("NAME_SHADOWING")
class MenuActivity: AppCompatActivity() {
    private var binding: ActivityMenuBinding? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val intent = intent
        val bundle = intent.getBundleExtra("bundle")
        val name = intent.getStringExtra("name")
        binding!!.tvmenu2.text = bundle?.getString("name", "kosong") + ("VS Pemain");
        binding!!.tvmenu3.text = bundle?.getString("name", "kosong") + ("VS CPU")
        Snackbar.make(binding!!.root, "Selamat Datang $name ", Snackbar.LENGTH_SHORT)
            .setAction("Tutup") {
            }.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE).show()

        binding!!.ibmenu1.setOnClickListener() {
            binding?.tvmenu2?.getText().toString().trim()
            val Intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            bundle.putString("name", name)
            Intent.putExtra("name", name)
            startActivity(Intent)
        }
            binding!!.ibmenu2.setOnClickListener() {
                binding?.tvmenu3?.getText().toString().trim()
                val Intent = Intent(this, ThirdActivity::class.java)
            val bundle = Bundle()
            bundle.putString("name", name)
//            intent.putExtra(Intent.EXTRA_TEXT,name)
                Intent.putExtra("name", name)
                startActivity(Intent)
            }
        }
    }