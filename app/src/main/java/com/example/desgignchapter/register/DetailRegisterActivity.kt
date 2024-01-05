package com.example.desgignchapter.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desgignchapter.R
import com.example.desgignchapter.databinding.ActivityDetailRegisterBinding

class DetailRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")
        binding.etEmail.setText(email)

        binding.ivBackArrow.setOnClickListener {
            finish()

        }
    }
}