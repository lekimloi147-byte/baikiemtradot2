package vn.udn.ute.week08.s2415141122111

import android.os.Bundle
package com.example.ltdd_kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ltdd_kt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            handleCheckProcess()
        }

        binding.btnClear.setOnClickListener {
            handleClearProcess()
        }
    }

    private fun handleCheckProcess() {
        binding.tvResult.text = ""

        val rawName = binding.edtCourseName.text.toString()
        val trimmedName = rawName.trim()
        if (trimmedName.isEmpty() || trimmedName.length > 40) {
            binding.edtCourseName.error = "Tên học phần phải từ 1 đến 40 ký tự!"
            return
        }
        val qtStr = binding.edtQT.text.toString()
        val qt = qtStr.toDoubleOrNull()
        if (qt == null || qt < 0.0 || qt > 10.0) {
            binding.edtQT.error = "Điểm QT phải là số thực từ 0 đến 10!"
            return
        }
        val ckStr = binding.edtCK.text.toString()
        val ck = ckStr.toDoubleOrNull()
        if (ck == null || ck < 0.0 || ck > 10.0) {
            binding.edtCK.error = "Điểm CK phải là số thực từ 0 đến 10!"
            return
        }
        val tScore = calculateT(qt, ck)
        val conclusion = classifyResult(tScore, ck)
        val resultText = """
            Tên HP: $trimmedName
            Điểm QT: %.2f
            Điểm CK: %.2f
            Điểm Tổng kết (T): %.2f
            Kết luận: $conclusion
        """.trimIndent().format(qt, ck, tScore)

        binding.tvResult.text = resultText
    }
    private fun calculateT(qt: Double, ck: Double): Double {
        return 0.4 * qt + 0.6 * ck
    }
    private fun classifyResult(t: Double, ck: Double): String {
        return if (t >= 5.5 && ck >= 3.0) {
            "Đạt"
        } else {
            "Chưa đạt"
        }
    }
    private fun handleClearProcess() {
        binding.edtCourseName.text.clear()
        binding.edtCourseName.error = null
        binding.edtQT.text.clear()
        binding.edtQT.error = null
        binding.edtCK.text.clear()
        binding.edtCK.error = null
        binding.tvResult.text = ""
    }
}