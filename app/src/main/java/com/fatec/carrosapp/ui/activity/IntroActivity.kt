package com.fatec.carrosapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.fatec.carrosapp.R
import com.fatec.carrosapp.ui.adapter.IntroViewPagerAdapter
import com.fatec.carrosapp.ui.fragment.ScreenItem
import com.google.android.material.tabs.TabLayout

class IntroActivity : AppCompatActivity() {

    private lateinit var screenPager : ViewPager
    private lateinit var introViewPagerAdapter: IntroViewPagerAdapter
    private lateinit var tabIndicator : TabLayout
    private val SCREEN_TEXT : String = "Coventry is a city with a thousand years of history that has plenty to offer the visiting tourist."


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        tabIndicator = findViewById(R.id.tab_indicator)
        screenPager = findViewById(R.id.viewPager)

        var list : ArrayList<ScreenItem> = ArrayList()
        list.add((ScreenItem(R.drawable.image_one, SCREEN_TEXT)))
        list.add((ScreenItem(R.drawable.image_two, SCREEN_TEXT)))
        list.add((ScreenItem(R.drawable.image_three,SCREEN_TEXT)))


        introViewPagerAdapter = IntroViewPagerAdapter(this, list)
        screenPager.adapter = introViewPagerAdapter

        tabIndicator.setupWithViewPager(screenPager)
    }
}
