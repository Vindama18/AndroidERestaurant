package fr.isen.esposito.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

  /*  butdessert.setOnClickListener(object: View.OnClickListener {
        override fun onClick(view: View): Unit {
            //Handler code here.
            val intent = Intent(context, dessert::class.java);
            startActivity(intent);
        }
    }*/
}

