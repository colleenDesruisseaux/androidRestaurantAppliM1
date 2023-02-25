package com.example.androidrestaurant

import android.content.DialogInterface.OnClickListener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrestaurant.databinding.CellCustomBinding
import com.example.androidrestaurant.network.Plate
import com.squareup.picasso.Picasso

class CustomAdapter(val items: List<Plate>, val clickListener: (Plate) -> Unit) : RecyclerView.Adapter<CustomAdapter.CellViewHolder>(){
    class CellViewHolder(binding: CellCustomBinding) : RecyclerView.ViewHolder(binding.root) {
    val textView: TextView = binding.itemName //id de textView dans cell_custom.xml
    val imageView = binding.imageView
    val priceTextView = binding.priceTextView
    val root: ConstraintLayout = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = CellCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val plate = items[position]
        //Nom du plat
        holder.textView.text = plate.name
        //Prix du plat
        holder.priceTextView.text = plate.prices.first().price + " €"
        //Image du plat
        Picasso.get().load(getThumbnail(plate)).into(holder.imageView)
        //Clic sur le plat
        holder.root.setOnClickListener{
            Log.d("click", "click on ${position+1}")
            clickListener(plate)
        }
    }

    private fun getThumbnail(plate: Plate): String? {
        //Gestion des plats qui ont ou pas des images. Echec creation viewPager...
        return if (plate.images.isNotEmpty() && plate.images.firstOrNull()?.isNotEmpty() == true){
            plate.images.firstOrNull()
        }else{
            null
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}
