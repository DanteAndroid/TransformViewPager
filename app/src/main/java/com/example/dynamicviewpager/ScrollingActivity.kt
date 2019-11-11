package com.example.dynamicviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_review_detail_header.*
import kotlinx.android.synthetic.main.activity_scrolling.*


class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        // 布局里使用 fitSystemWindows 导致有一个状态栏高度的 padding 存在
        // 暂时没找到好的解决方案。有的话请告诉我
        // https://stackoverflow.com/questions/48137666/viewgroup-inside-collapsingtoolbarlayout-show-extra-bottom-padding-when-set-fits

        init()
    }

    private fun init() {
        val images = Gson().fromJson(JSON_DATA, Array<Image>::class.java).asList()
        viewPager.adapter = TransformViewPagerAdapter(supportFragmentManager, images)
    }
}
