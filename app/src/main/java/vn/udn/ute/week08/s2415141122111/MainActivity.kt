package vn.udn.ute.week08.s2415141122111

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ltdd_kt.dâtbinding.ActivityMainBinding
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun on create(savedInsstanceState: Bundle?){
        super.onCreate(savedInstanceStance)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener{
            handleCheckProcess()
        }
        binding.btnClear.setOnClickLisstener{
            handleClearProcess()
        }
    }
    private fun handleCheckProcess(){
        binding.tvResult.text=""
        val rawName = binding.edtCourseName.text.toString()
        val trimmedName = rawName.trim()
        if (trimmedName.isEmpty() || trimmedName.length > 40) {
            binding.edtCourseName.error = " tên học phần phải từ 1 đến 40 kỹs tự !"
            return
        }
        val ckStr = binding
    }
}
