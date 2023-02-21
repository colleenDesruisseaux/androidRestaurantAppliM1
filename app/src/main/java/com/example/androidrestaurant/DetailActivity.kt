package com.example.androidrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidrestaurant.databinding.ActivityDetailBinding
import com.example.androidrestaurant.network.Plate
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    companion object{
        val PLATE_EXTRA = "PLATE_EXTRA"
    }

    lateinit var binding: ActivityDetailBinding
    var plate: Plate? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plate = intent.getSerializableExtra(PLATE_EXTRA) as? Plate

        val ingredients = plate?.ingredients?.map {it.nameIngr}?.joinToString(", ") ?: ""
        binding.textView.text = ingredients
    }
}