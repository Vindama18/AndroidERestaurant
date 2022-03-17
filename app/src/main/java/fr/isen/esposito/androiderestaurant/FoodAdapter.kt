package fr.isen.esposito.androiderestaurant

import android.telecom.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

//data class Food(val id: Long, val nom: String, val prix: String):Serializable


class FoodAdapter(val FoodAfficher: List<Items>, val listener: (Items) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = FoodAfficher.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("XXX", "onBindViewHolder")
        holder.dishName.text = FoodAfficher[position].name_fr
        holder.prix.text=FoodAfficher[position].prices[0].price
            holder.itemView.setOnClickListener { listener(FoodAfficher[position])
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishName : TextView = view.findViewById(R.id.categoryTitle)
        val prix : TextView=view.findViewById(R.id.prix)
    }
}

