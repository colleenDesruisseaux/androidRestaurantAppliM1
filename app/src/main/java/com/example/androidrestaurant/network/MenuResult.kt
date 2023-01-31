package com.example.androidrestaurant.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class MenuResult(@SerializedName("data")val data: List<Category>): Serializable { //La variable Category doit être construite avec la variable data qui correspond aux données de notre JSON

}