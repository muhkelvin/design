package com.example.desgignchapter.register

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.desgignchapter.R
import com.example.desgignchapter.data.model.RegisterResponse
import com.example.desgignchapter.data.network.UserApi
import com.example.desgignchapter.data.network.UserBuilder
import com.example.desgignchapter.data.repository.UserRepository
import com.example.desgignchapter.data.viewmodel.UserViewModel
import com.example.desgignchapter.databinding.ActivityDetailRegisterBinding

class DetailRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRegisterBinding

    private val userApi: UserApi by lazy {
        UserBuilder.instanceUser
    }

    private val repository: UserRepository by lazy {
        UserRepository(userApi)
    }

    private val viewModel: UserViewModel by viewModels {
        UserViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val spannableString = SpannableString("Dengan membuat akun kamu menyetujui Syarat, Ketentuan dan Kebijakan Privasi Kaboor")
            val blueSpan = ForegroundColorSpan(Color.parseColor("#166df7"))
            val start = spannableString.indexOf("Syarat, Ketentuan dan Kebijakan")
            val end = start + "Syarat, Ketentuan dan Kebijakan".length
            spannableString.setSpan(blueSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            binding.syaratKetentuan.text = spannableString

        binding.ivBackArrow.setOnClickListener {
            finish()

        }
}}
