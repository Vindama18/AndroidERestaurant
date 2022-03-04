package fr.isen.esposito.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

val texttitle = findViewById<TextView>(R.id.textitem)
        texttitle.text=intent.getStringExtra("12345")
        setTitle(intent.getStringExtra("12345"))




        val back = findViewById<Button>(R.id.butback)


        // set on-click listener
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
            Toast.makeText(this , "menu principal", Toast.LENGTH_SHORT).show()
        }
    }
}