package com.percobaan.mysprgames

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class PagerAdapter (fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    private val fragment = arrayOf(LP1Fragment(),LP2Fragment(),LP3Fragment())
    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragment[position]
    }

}