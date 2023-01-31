package com.example.androidrestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Price (
    @SerializedName("price") val price: String //Affiche le prix
    ): Serializable