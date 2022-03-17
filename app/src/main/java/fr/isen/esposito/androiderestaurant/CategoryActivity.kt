package fr.isen.esposito.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryActivity : AppCompatActivity() {
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
}