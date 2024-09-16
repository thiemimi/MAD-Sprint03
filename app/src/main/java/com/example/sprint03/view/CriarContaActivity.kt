package com.example.sprint03.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint03.databinding.ActivityCriarContaBinding

class CriarContaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCriarContaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCriarContaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCadastrar.setOnClickListener(){
            abrirDashboard()
        }

        binding.buttonFacaLogin.setOnClickListener(){
            abrirLogin()
        }
    }

    private fun abrirDashboard(){
        val intent = Intent(this, DashboardActivity::class.java )
        startActivity(intent)
    }

    private fun abrirLogin(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
