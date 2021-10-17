package com.vdemelo.masknumbers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vdemelo.masknumbers.common.NumberTypeEnum
import com.vdemelo.masknumbers.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUI()
        initObservers()
    }

    private fun initUI(){
    }

    private fun initObservers(){
        mainViewModel.numberType.observe(this, ::onObserveNumberType)
    }

    private fun onObserveNumberType(numberType: NumberTypeEnum?) {
        // 1. Mudar texto no campo seletor
        // 2. Mudar hint do EditText
        // 3. Mudar TextWatcher, nova máscara
    }
}