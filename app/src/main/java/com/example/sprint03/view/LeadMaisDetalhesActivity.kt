package com.example.sprint03.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint03.databinding.ActivityLeadMaisDetalhesBinding

class LeadMaisDetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeadMaisDetalhesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLeadMaisDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.SetaVoltar.setOnClickListener{
            voltarLeads()
        }

        setupViews()

    }

    private fun setupViews(){
        val email = intent.getStringExtra("EXTRA_EMAIL").orEmpty()
        val telefone = intent.getStringExtra("EXTRA_TELEFONE").orEmpty()

        binding.textViewLeadEmail.text = email
        binding.textViewLeadTelefone.text = telefone

    }

    private fun voltarLeads(){
        val intent = Intent(this, LeadActivity::class.java)
        startActivity(intent)
    }
}