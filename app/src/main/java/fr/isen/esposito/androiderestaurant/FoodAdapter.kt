package fr.isen.esposito.androiderestaurant

import android.annotation.SuppressLint
import android.telecom.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.io.Serializable

//data class Food(val id: Long, val nom: String, val prix: String):Serializable


class FoodAdapter(private val FoodAfficher: List<Items>, val listener: (Items) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = FoodAfficher.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = FoodAfficher[position]
        val id = menu.id.toInt()
        holder.dishTile.text = menu.name_fr
        holder.dishPrice.text = menu.prices[0].price +"€"
        Picasso.get().load(menu.images[0].ifEmpty { null })
            .error(R.drawable.plat_en_ardoise_olympia_pour_plateau_cm061_280x180mm_removebg_preview)
            .into(holder.photo)
        holder.itemView.setOnClickListener {
            listener(menu)
        }

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val dishTile: TextView = ItemView.findViewById(R.id.Titleplat)
        val dishPrice: TextView = ItemView.findViewById(R.id.Platprix)
        val photo : ImageView = ItemView.findViewById(R.id.photo)
    }
}

