package com.example.desgignchapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desgignchapter.databinding.ActivityMainBinding
import com.example.desgignchapter.databinding.BottomSheetDetailPemesanBinding
import com.example.desgignchapter.databinding.BottomSheetPenumpangBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPemesan.setOnClickListener {
            val buttomSheetDialog = BottomSheetDialog(this)
            val bottomSheetbinding = BottomSheetDetailPemesanBinding.inflate(layoutInflater)
            buttomSheetDialog.setContentView(bottomSheetbinding.root)

            buttomSheetDialog.show()

            bottomSheetbinding.ivClose.setOnClickListener {
                buttomSheetDialog.dismiss()
            }

        }

        binding.btPemumpang.setOnClickListener {
            val sheet = BottomSheetDialog(this)
            val sheetBinding = BottomSheetPenumpangBinding.inflate(layoutInflater)
            sheet.setContentView(sheetBinding.root)

            sheet.show()
        }
    }

}