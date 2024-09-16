package com.example.sprint03.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sprint03.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.CardCadastrarLead.setOnClickListener{
            abrirCadastrarLead()
        }
        binding.CardLead.setOnClickListener{
            abrirLeads()
        }
        binding.CardInterest.setOnClickListener{
            abrirInterests()
        }
        binding.CardFeedback.setOnClickListener{
            abrirFeedback()
        }

        binding.buttonLogout.setOnClickListener{
            logout()
        }


    }

    private fun abrirCadastrarLead(){
        val intent = Intent(this, CadastrarLeadActivity::class.java)
        startActivity(intent)
    }

    private fun abrirLeads(){
        val intent = Intent(this, LeadActivity:: class.java)
        startActivity(intent)
    }

    private fun abrirInterests(){
        val intent = Intent(this, InterestsActivity:: class.java)
        startActivity(intent)
    }

    private fun abrirFeedback(){
        val intent = Intent(this, FeedbackActivity:: class.java)
        startActivity(intent)
    }

    private fun logout(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}