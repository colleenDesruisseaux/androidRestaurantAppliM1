package com.example.androidrestaurant.network

import android.provider.MediaStore.Images
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Plate (
    @SerializedName("name_fr") val name: String, //Nom du plat
    @SerializedName("images") val images: List<String>, //Image du plat
    @SerializedName("prices") val prices: List<Price>, //Liste des prix pour ce plat
    @SerializedName("ingredients") val ingredients: List<Ingredient> //Liste des ingrédients
    ): Serializable