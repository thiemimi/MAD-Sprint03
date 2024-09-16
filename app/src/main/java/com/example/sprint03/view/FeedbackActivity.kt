package com.example.sprint03.view

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.sprint03.databinding.ActivityFeedbackBinding


class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SetaVoltar.setOnClickListener{
            abrirDashboard()
        }
        binding.buttonCancelar.setOnClickListener(){
            abrirDashboard()
        }

        exibirSpinner()
    }

    private fun abrirDashboard(){
        val intent = Intent(this, DashboardActivity::class.java )
        startActivity(intent)
    }


    private fun exibirSpinner() {
        val lista: List<String> = listOf("Lead 1", "Lead 2", "Lead 3")
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            lista
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLeads.adapter = adapter
    }
}