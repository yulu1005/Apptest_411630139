package com.example.harrypotter_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 取得 ViewPager2
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        // 設定 Adapter
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        // 如果想一開始就顯示第一頁 (位置=0)，可以手動指定
        viewPager.currentItem = 0
    }
}
