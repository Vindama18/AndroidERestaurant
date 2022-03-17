package fr.isen.esposito.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        const val CATEGORY_KEY ="cat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val entre = findViewById<Button>(R.id.butentre)
        val plat = findViewById<Button>(R.id.butplat)
        val dessert = findViewById<Button>(R.id.butdessert)


        // set on-click listener
        entre.setOnClickListener {
            startCategory(getString(R.string.butentre))
            Toast.makeText(this , "Entrées", Toast.LENGTH_SHORT).show()
        }

        // set on-click listener
        plat.setOnClickListener {
            startCategory(getString(R.string.butplat))
            Toast.makeText(this, "Plats", Toast.LENGTH_SHORT).show()
        }

        // set on-click listener
        dessert.setOnClickListener {
            startCategory(getString(R.string.butdessert))
            Toast.makeText(this, "Desserts", Toast.LENGTH_SHORT).show()
        }

    }

    private fun startCategory(category : String) {
        val intent =
            Intent(this, CategoryActivity::class.java).apply { putExtra("12345", category) }
        startActivity(intent);
    }
}

