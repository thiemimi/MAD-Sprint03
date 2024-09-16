package com.example.sprint03.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint03.databinding.ActivityCadastrarLeadBinding

class CadastrarLeadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarLeadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastrarLeadBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.SetaVoltar.setOnClickListener(){
            abrirDashboard()
        }
        binding.buttonCancelar.setOnClickListener(){
            abrirDashboard()
        }

    }

    private fun abrirDashboard(){
        val intent = Intent(this, DashboardActivity::class.java )
        startActivity(intent)
    }


}