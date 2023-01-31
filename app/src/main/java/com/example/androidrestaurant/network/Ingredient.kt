package com.example.androidrestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Ingredient (
    @SerializedName("ingredients") val ingredients: String //Affiche le nom de l'ingrédient
): Serializable