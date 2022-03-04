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

        val  food = CreerMesLigne()
        var monRecycler: RecyclerView = findViewById(R.id.categoryListe)
        monRecycler.layoutManager = LinearLayoutManager(this)
        monRecycler.adapter = FoodAdapter(food.toTypedArray())
        {
            Toast.makeText(this, "Vous avez sélectionné ${it.nom}", Toast.LENGTH_SHORT).show()
        }

        val back = findViewById<Button>(R.id.butback)

        // set on-click listener
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
            Toast.makeText(this , "menu principal", Toast.LENGTH_SHORT).show()
        }
    }



    fun CreerMesLigne() :ArrayList<Food> {
        val food = ArrayList<Food>()
        food.add(Food(1, "Loup"))
        food.add(Food(2, "Gorille"))
        food.add(Food(3, "Eléphant"))
        food.add(Food(4, "Tigre"))
        food.add(Food(5, "Dauphin"))

        return food
    }
}