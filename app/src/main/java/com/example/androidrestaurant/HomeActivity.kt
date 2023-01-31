package com.example.androidrestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.androidrestaurant.databinding.ActivityHomeBinding



class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonsListener()
    }

    private fun buttonsListener() {
        binding.starterButton.setOnClickListener{
            //Log.d("button", "Click sur button entrée")
            //Toast.makeText(this, "Entrée", Toast.LENGTH_LONG).show()
            //val intent = Intent(this, PlatsActivity::class.java)
            //startActivity(intent)
            showCategory(Category.STARTER)
        }

        binding.mainButton.setOnClickListener{
           // Log.d("button", "Click sur button plats")
            //Toast.makeText(this, "Plats", Toast.LENGTH_LONG).show()
            //val intent = Intent(this, PlatsActivity::class.java)
            //startActivity(intent)
            showCategory(Category.MAIN)
        }

        binding.finishButton.setOnClickListener{
            //Log.d("button", "Click sur button dessert")
            //Toast.makeText(this, "Desserts", Toast.LENGTH_LONG).show()
            //val intent = Intent(this, PlatsActivity::class.java)
            //startActivity(intent)
            showCategory(Category.DESSERT) //Quand on clique sur le bouton dessert, on affiche la page dessert et le titre DESSERT
        }
    }

    private fun showCategory(category: Category){
        val intent = Intent(this, PlatsActivity::class.java)
        intent.putExtra(PlatsActivity.extraKey, category)
        startActivity(intent)
    }
}