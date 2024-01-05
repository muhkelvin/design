package com.example.desgignchapter.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desgignchapter.R
import com.example.desgignchapter.databinding.ActivitySheetBinding
import com.example.desgignchapter.databinding.BottomSheetPenumpangBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SheetActivity : AppCompatActivity() {
    lateinit var binding:ActivitySheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.penumpang.setOnClickListener {
           val sheet = BottomSheetDialog(this)
            val sheetBinding = BottomSheetPenumpangBinding.inflate(layoutInflater)
            sheet.setContentView(sheetBinding.root)

            sheet.show()
        }
    }
}