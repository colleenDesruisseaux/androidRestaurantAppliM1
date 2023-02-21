package com.example.androidrestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Ingredient (
    @SerializedName("name_fr") val nameIngr: String //Affiche le nom de l'ingrédient
): Serializable