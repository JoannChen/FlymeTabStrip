package com.joann.chen.flymetabstrip

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val titles = arrayOf("男生", "女生")
    private lateinit var mAdapter: RecommendPageAdapter

    // 男频
    val manFragment: FlymeFragment by lazy {
        FlymeFragment()
    }

    // 女频
    val girlFragment: FlymeFragment by lazy {
        FlymeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = RecommendPageAdapter(supportFragmentManager)
        viewPage.adapter = mAdapter
        tabStrip.setViewPager(viewPage)

        viewPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                viewPage.currentItem = position
            }

        })
    }


    private inner class RecommendPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount() = titles.size

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> manFragment
            1 -> girlFragment
            else -> manFragment
        }

        override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE

        override fun getPageTitle(position: Int): CharSequence = titles[position]
    }

}
