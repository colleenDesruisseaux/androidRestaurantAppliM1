package com.example.androidrestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidrestaurant.databinding.ActivityDetailBinding
import com.example.androidrestaurant.network.Plate

class DetailActivity : AppCompatActivity() {

    companion object{
        val PLATE_EXTRA = "PLATE_EXTRA"
    }

    lateinit var binding: ActivityDetailBinding
    var plate: Plate? = null
    private var qt :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plate = intent.getSerializableExtra(PLATE_EXTRA) as? Plate

        val ingredients = plate?.ingredients?.map {it.nameIngr}?.joinToString(", ") ?: ""
        binding.textView.text = ingredients
        binding.quantity.text = qt.toString()
        binding.boutonTotal.text = "PRIX TOTAL " + "0" + "€"
        binding.nbArticle.text = "0"
        supportActionBar?.title = "Détails"
        buttonsListener()
    }

    private fun buttonsListener(){
        var totP = plate?.prices?.first()?.price?.toFloat()
        binding.boutonPlus.setOnClickListener {
            qt++
            var totalP = totP?.times(qt)
            binding.quantity.text = qt.toString()
            //binding.nbArticle.text = binding.quantity.text
            binding.boutonTotal.text = "PRIX TOTAL " + totalP.toString() + "€"
        }
        binding.boutonMoins.setOnClickListener {
            qt--
            var totalP = totP?.times(qt)
            binding.quantity.text = qt.toString()
            //binding.nbArticle.text = binding.quantity.text
            binding.boutonTotal.text = "PRIX TOTAL " + totalP.toString() + "€"
        }

        binding.boutonTotal.setOnClickListener {
            binding.nbArticle.text = binding.quantity.text
            Toast.makeText(this, "${binding.quantity.text} articles ajoutés au panier !", Toast.LENGTH_LONG).show()
        }

        binding.panier.setOnClickListener{
            val intent = Intent(this, PanierActivity::class.java)
            startActivity(intent)
        }
    }
}