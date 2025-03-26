package com.example.harrypotter_app

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class SecondFragment : Fragment() {

    private val houses = arrayOf("葛來分多", "史萊哲林", "雷文克勞", "赫夫帕夫")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val btnChooseHouse = view.findViewById<Button>(R.id.btnChooseHouse)
        btnChooseHouse.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("分院帽決定...")
                .setItems(houses) { _, which ->
                    val selectedHouse = houses[which]
                    Toast.makeText(requireContext(), "你被分到：$selectedHouse！", Toast.LENGTH_SHORT).show()

                    // ★ 加入這段：跳到第三頁 (position = 2)
                    val parentActivity = activity as? MainActivity
                    parentActivity?.findViewById<ViewPager2>(R.id.viewPager)?.currentItem = 2
                }
                .setNegativeButton("取消", null)
                .show()
        }

        return view
    }
}
