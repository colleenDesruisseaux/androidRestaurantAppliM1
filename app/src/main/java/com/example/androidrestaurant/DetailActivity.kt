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

        //Liste des ingrédients du plat sélectionné
        val ingredients = plate?.ingredients?.map {it.nameIngr}?.joinToString(", ") ?: ""
        //Affichage de la liste des ingrédients
        binding.textView.text = ingredients

        //Affichage de la quantité qui varie en fonction des boutons moins et plus.
        binding.quantity.text = qt.toString()

        //Au début, le bouton PRIX TOTAL affiche 0€. Ensuite, le prix va varier en fonction de la quantité
        binding.boutonTotal.text = "PRIX TOTAL " + "0" + "€"
        //Nombre d'articles égale à 0 au début (pastille à côté du logo chariot) et va varier si on clique sur "PRIX TOTAL" (signifie qu'on l'ajoute au panier)
        binding.nbArticle.text = "0"

        //Titre de la page
        supportActionBar?.title = "Détails"
        buttonsListener()
    }

    private fun buttonsListener(){
        var totP = plate?.prices?.first()?.price?.toFloat()

        //Action bouton plus. +1 à la quantité
        binding.boutonPlus.setOnClickListener {
            qt++

            //Prix total = prix du plat * quantité
            var totalP = totP?.times(qt)
            //qt est un entier. On le transforme en string pour qu'il s'affiche dans le textView
            binding.quantity.text = qt.toString()
            binding.boutonTotal.text = "PRIX TOTAL " + totalP.toString() + "€"
        }

        //Action bouton moins. -1 à la quantité
        binding.boutonMoins.setOnClickListener {
            qt--

            //Prix total = prix du plat * quantité
            var totalP = totP?.times(qt)
            //qt est un entier. On le transforme en string pour qu'il s'affiche dans le textView
            binding.quantity.text = qt.toString()
            binding.boutonTotal.text = "PRIX TOTAL " + totalP.toString() + "€"
        }

        //Action bouton PRIX TOTAL. Echec de la création du fichier informations JSON. Donc pas de stockage des articles...
        binding.boutonTotal.setOnClickListener {
            //Au clic sur PRIX TOTAL -> mise à jour du nombre d'articles au niveau du logo panier.
            binding.nbArticle.text = binding.quantity.text
            Toast.makeText(this, "${binding.quantity.text} articles ajoutés au panier !", Toast.LENGTH_LONG).show()
        }

        //Action clic sur logo panier. Redirection vers PanierActivity
        binding.panier.setOnClickListener{
            val intent = Intent(this, PanierActivity::class.java)
            startActivity(intent)
        }
    }
}