package com.percobaan.mysprgames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.percobaan.mysprgames.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PagerAdapter(this)
        val itemTexts = arrayOf("LP1", "LP2", "LP3")
        var currentPosition = 0
        binding.let {
            it.viewPager.adapter = adapter
            it.springDotsIndicator.setViewPager2(it.viewPager)
            it.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    currentPosition = position
                    if (currentPosition == 0) {
                        it.btnNext.visibility = View.GONE
                    } else if (currentPosition == (itemTexts.size - 2)) {
                        it.btnNext.visibility = View.GONE
                    } else {
                        it.btnNext.visibility = View.VISIBLE
                    }
//                    it.btnNext.setOnClickListener {
//                        currentPosition++
//                        binding.viewPager.setCurrentItem(currentPosition, true)
//                    }
                }
            })
            }
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java))
        }
        }
    }
