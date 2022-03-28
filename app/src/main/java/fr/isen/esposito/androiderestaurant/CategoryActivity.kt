package fr.isen.esposito.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.esposito.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject


class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val title = intent.getStringExtra("Category")
        binding.textitem.text = title
        binding.categoryListe.layoutManager = LinearLayoutManager(this)
        binding.categoryListe.adapter = FoodAdapter(arrayListOf()) {}

        if (title != null) {
            loadItemsFromServer(title)
        }
    }

    private fun loadItemsFromServer(category : String) {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val obj = JSONObject()
        obj.put("id_shop", "1")
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, obj,
            { response ->

                Log.d("Response", "$response")
                Log.d("MenuActivity", "Api call succes")
                val menu = Gson().fromJson(response.toString(), Data::class.java)

                val items = menu.data.firstOrNull{ it.name_fr == category }?.items ?: listOf() // "?."  propage le null et "?:" si c'est null, Si il n'a pas trouvé d'élement par rapport à la catégorie,il renvoie null
                val adapter = FoodAdapter(items) {
                    val intent = Intent(this, Details::class.java)

                    intent.putExtra(DETAILS_KEY, it)
                    startActivity(intent)
                }
                //binding.loaderIcon.visibility = View.GONE
                binding.categoryListe.adapter = adapter

            },
            { error ->
                Log.d("MenuActivity", "Api call failed")
            }
        )
        queue.add(jsonObjectRequest)
    }

    companion object {
        const val DETAILS_KEY = "details"
    }



}










/*class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

val texttitle = findViewById<TextView>(R.id.textitem)
        texttitle.text=intent.getStringExtra("12345")
        setTitle(intent.getStringExtra("12345"))

        val  food = CreerMesLigne(texttitle)
        var monRecycler: RecyclerView = findViewById(R.id.categoryListe)
        monRecycler.layoutManager = LinearLayoutManager(this)
        monRecycler.adapter = FoodAdapter(food.toTypedArray())
        {
            Toast.makeText(this, "Vous avez sélectionné ${it.nom}", Toast.LENGTH_SHORT).show()

            val intent = Intent(this,Details :: class.java)
            startActivity(intent)
        }

        val back = findViewById<Button>(R.id.butback)

        // set on-click listener
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
            Toast.makeText(this , "menu principal", Toast.LENGTH_SHORT).show()
        }
    }

    fun CreerMesLigne(textetitle:TextView) :ArrayList<Food> {
        val food = ArrayList<Food>()
        if (textetitle.text=="Entrées") {
            food.add(Food(1, "apéritif","7€"))
            food.add(Food(2, "salade","5€"))
            food.add(Food(2, "Bruschetta","7,50€"))
        }
        if (textetitle.text=="Plats") {
            food.add(Food(1, "Burger maison","20€"))
            food.add(Food(2, "Lasagne a la bolognaise","18€"))
            food.add(Food(2, "Dorade fumée","22€"))
        }
        if (textetitle.text=="Désserts") {
            food.add(Food(1, "Fondant au chocolat","3€"))
            food.add(Food(2, "île flotante","4,50€"))
            food.add(Food(2, "Mousse au chocolat","4€"))
        }

        return food
    }
}*/