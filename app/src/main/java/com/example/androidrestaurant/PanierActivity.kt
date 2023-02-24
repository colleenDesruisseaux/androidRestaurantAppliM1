package com.example.androidrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidrestaurant.databinding.ActivityDetailBinding
import com.example.androidrestaurant.databinding.ActivityPanierBinding

class PanierActivity : AppCompatActivity() {
    lateinit var binding: ActivityPanierBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Panier"
        buttonListener()
    }

    private fun buttonListener(){
        binding.order.setOnClickListener {
            Toast.makeText(this, "Commande enregistrée !", Toast.LENGTH_LONG).show()
        }
    }
}