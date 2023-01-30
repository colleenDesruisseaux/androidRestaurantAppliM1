package com.example.androidrestaurant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.androidrestaurant.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener()
    }

    private fun buttonsListener() {
        binding.starterButton.setOnClickListener{
            Log.d("button", "Click sur button entrée")
            Toast.makeText(this, "Entrée", Toast.LENGTH_LONG).show()
        }

        binding.mainButton.setOnClickListener{
            Log.d("button", "Click sur button plats")
            Toast.makeText(this, "Plats", Toast.LENGTH_LONG).show()
        }

        binding.finishButton.setOnClickListener{
            Log.d("button", "Click sur button dessert")
            Toast.makeText(this, "Desserts", Toast.LENGTH_LONG).show()
        }
    }
}