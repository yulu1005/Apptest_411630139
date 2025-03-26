package com.example.harrypotter_app

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class ThirdFragment : Fragment() {

    private val wandOptions = arrayOf("鳳凰羽毛", "獨角獸毛髓", "龍心弦", "紫杉木", "榛木", "橡木")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val btnChooseWand = view.findViewById<Button>(R.id.btnChooseWand)

        btnChooseWand.setOnClickListener {
            val selectedItems = mutableListOf<Int>()

            AlertDialog.Builder(requireContext())
                .setTitle("選擇你的魔杖特性")
                .setMultiChoiceItems(wandOptions, null) { _, which, isChecked ->
                    if (isChecked) {
                        selectedItems.add(which)
                    } else {
                        selectedItems.remove(which)
                    }
                }
                .setPositiveButton("完成") { _, _ ->
                    val selectedText = selectedItems.joinToString(" + ") { wandOptions[it] }
                    Toast.makeText(requireContext(), "你打造了一根：$selectedText 魔杖！", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("取消", null)
                .show()
        }

        return view
    }
}
