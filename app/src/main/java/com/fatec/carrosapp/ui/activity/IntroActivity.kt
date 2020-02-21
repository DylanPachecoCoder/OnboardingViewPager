package com.fatec.carrosapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import com.fatec.carrosapp.R
import com.fatec.carrosapp.model.ScreenItem
import com.fatec.carrosapp.ui.adapter.IntroViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    private lateinit var screenPager: ViewPager
    private lateinit var introViewPagerAdapter: IntroViewPagerAdapter
    private lateinit var tabIndicator: TabLayout
    private val SCREEN_TEXT: String =
        "Coventry is a city with a thousand years of history that has plenty to offer the visiting tourist."


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreenMode()
        setContentView(R.layout.activity_intro)

        val buttonFinish  = onboarding_button_finish
        buttonFinish.visibility = View.INVISIBLE

        var list: ArrayList<ScreenItem> = createListOfPages()
        setViewPager(list)
        setDotsIndicator()

        val buttonNext  = onboarding_button_next

        buttonNext.setOnClickListener {

            var position = screenPager.currentItem
            if(position < list.size){
                position++
                screenPager.currentItem = position
            }

            if(position == (list.size -1)){
                buttonNext.visibility = View.INVISIBLE
                buttonFinish.visibility = View.VISIBLE

                finishOnboarding()
            }
        }
    }

    private fun finishOnboarding() {

    }

    private fun setDotsIndicator() {
        tabIndicator = findViewById(R.id.tab_indicator)
        tabIndicator.setupWithViewPager(screenPager)
    }

    private fun setViewPager(list: ArrayList<ScreenItem>) {
        introViewPagerAdapter = IntroViewPagerAdapter(this, list)
        screenPager = findViewById(R.id.viewPager)
        screenPager.adapter = introViewPagerAdapter
    }

    private fun createListOfPages(): ArrayList<ScreenItem> {
        var list: ArrayList<ScreenItem> = ArrayList()
        list.add((ScreenItem(R.drawable.image_one, SCREEN_TEXT)))
        list.add((ScreenItem(R.drawable.image_two, SCREEN_TEXT)))
        list.add((ScreenItem(R.drawable.image_three, SCREEN_TEXT)))
        return list
    }

    private fun setFullScreenMode() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}
