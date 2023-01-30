package com.example.androidrestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidrestaurant.databinding.ActivityPlatsBinding

enum class Category { STARTER , MAIN , DESSERT }

class PlatsActivity : AppCompatActivity() {

    companion object {
        val extraKey = "extraKey"
    }

    lateinit var binding: ActivityPlatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getSerializableExtra(extraKey) as? Category

        supportActionBar?.title = categoryName(category ?: Category.STARTER) //STARTER est par défaut
        //if category == null { category = STARTER }
    }

    private fun categoryName(category: Category): String{
        return when(category) {
            Category.STARTER -> getString(R.string.starter)
            Category.MAIN -> getString(R.string.main)
            Category.DESSERT -> getString(R.string.finish)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "onResume")
    }

    override fun onDestroy() {
        Log.i("suppr", "Au Revoir")
        super.onDestroy()
    }
}