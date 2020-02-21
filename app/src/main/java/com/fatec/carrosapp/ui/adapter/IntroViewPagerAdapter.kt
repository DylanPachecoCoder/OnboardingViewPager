package com.fatec.carrosapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.fatec.carrosapp.R
import com.fatec.carrosapp.model.ScreenItem

class IntroViewPagerAdapter(
    private var context: Context,
    private var listScreen : List<ScreenItem>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService((Context.LAYOUT_INFLATER_SERVICE)) as LayoutInflater
        val layoutScreen = inflater.inflate(R.layout.layout_screen, null)

        val imgSlide = layoutScreen.findViewById<ImageView>(R.id.onboarding_fragment_imageview)
        val textSlide = layoutScreen.findViewById<TextView>(R.id.onboarding_fragment_textview)
        imgSlide.setImageResource(listScreen.get(position).screenImage)
        textSlide.setText(listScreen.get(position).screenText)

        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun getCount(): Int {
        return listScreen.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}