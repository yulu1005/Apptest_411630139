package com.example.harrypotter_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2  // ← 確認這行存在

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 載入畫面
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // 綁定按鈕
        val btnStart = view.findViewById<Button>(R.id.btnStart)

        // 點擊事件：顯示 Toast，並切換到第二頁
        btnStart.setOnClickListener {
            Toast.makeText(requireContext(), "入學成功，準備展開冒險！", Toast.LENGTH_SHORT).show()

            // 讓 ViewPager2 跳到第二頁 (position = 1)
            val parentActivity = activity as? MainActivity
            parentActivity?.findViewById<ViewPager2>(R.id.viewPager)?.currentItem = 1
        }

        return view
    }
}
