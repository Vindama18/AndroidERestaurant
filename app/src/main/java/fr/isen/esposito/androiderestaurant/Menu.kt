package fr.isen.esposito.androiderestaurant

import com.google.gson.annotations.SerializedName
import java.io.Serializable

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject


data class Data(
    val data : List<Menu>
): Serializable
data class Menu (
    @SerializedName("name_fr")
    val name_fr: String,
    @SerializedName("name_en")
    val name_en : String,
    @SerializedName("items")
    val items : List<Items>
): Serializable

data class Items (
    @SerializedName("id")
    val id : String,
    @SerializedName("name_fr")
    val name_fr : String,
    @SerializedName("images")
    val images : List<String>,
    @SerializedName("ingredients")
    val ingredients : List<Ingredients>,
    @SerializedName("prices")
    val prices : ArrayList<Prices>
) : Serializable

data class Prices(
    @SerializedName("price")
    val price: String
) : Serializable

data class Ingredients(
    @SerializedName("name_fr")
    val name_fr: String
) : Serializable