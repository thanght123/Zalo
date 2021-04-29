package com.example.ptitzalo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HomeViewPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return MessFragment()
            1 -> return ContactFragment()
            2 -> return GroupFragment()
            3 -> return DiaryFragment()
            3 -> return MoreFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 4
    }
}
