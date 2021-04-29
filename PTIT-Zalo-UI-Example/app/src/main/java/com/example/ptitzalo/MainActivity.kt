package com.example.ptitzalo

import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initView()
        createPopupMenu()
        setAction()
    }

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var tabIcon: ImageView
    private lateinit var viewPager: ViewPager

    private fun initView() {
        bottomNavigationView = findViewById(R.id.navigation)
        tabIcon = findViewById(R.id.tab_icon)
        viewPager = findViewById(R.id.container)
        bottomNavigationView.itemIconSize = 52

        var homeViewPagerAdapter = HomeViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = homeViewPagerAdapter

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, MessFragment.newInstance())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setAction() {
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottomNavigationView.menu.findItem(R.id.mess).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.contact).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.group).isChecked = true
                    3 -> bottomNavigationView.menu.findItem(R.id.diary).isChecked = true
                    4 -> bottomNavigationView.menu.findItem(R.id.more).isChecked = true
                }
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mess -> {
                    viewPager.currentItem = 0
                }
                R.id.contact -> {
                    viewPager.currentItem = 1

                }
                R.id.diary -> {
                    viewPager.currentItem = 3

                }
                R.id.group -> {
                    viewPager.currentItem = 2

                }
                R.id.more -> {
                    viewPager.currentItem = 4
                }
            }
            false
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createPopupMenu(){
        val popupMenu= PopupMenu(applicationContext, tabIcon)
        popupMenu.inflate(R.menu.top_bar_menu)

        val popup = PopupMenu::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val menu = popup.get(popupMenu)
        menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java).invoke(menu, true)
        tabIcon.setOnClickListener {
            popupMenu.show()
        }
    }
}