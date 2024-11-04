package com.example.sprint03.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.sprint03.R
import com.example.sprint03.databinding.ActivityLeaddBinding

class LeaddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeaddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }
}