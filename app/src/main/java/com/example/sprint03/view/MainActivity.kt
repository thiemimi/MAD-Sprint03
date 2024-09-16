package com.example.sprint03.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.sprint03.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(){
            abrirDashboard()
        }

        binding.buttonCriarConta.setOnClickListener(){
            abrirCriarConta()
        }
    }

    private fun abrirDashboard(){
        val intent = Intent(this, DashboardActivity::class.java )
        startActivity(intent)
    }

    private fun abrirCriarConta(){
        val intent = Intent(this, CriarContaActivity::class.java)
        startActivity(intent)
    }
}

