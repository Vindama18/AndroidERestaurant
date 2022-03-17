package fr.isen.esposito.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.esposito.androiderestaurant.databinding.ActivityDetailsBinding

//class Details : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_details)
 //   }
//}

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
import android.util.Log

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = intent

        val item = intent.getSerializableExtra(CategoryActivity.DETAILS_KEY) as Items
        binding.dishname.text = item.name_fr



        binding.dishdescription.text = item.ingredients.joinToString(", ", transform = { it.name_fr })

        Log.i("image", item.images.toString())
        //binding.viewSilder.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //binding.viewSilder.adapter = ViewAdapter(this,item.images)

    }
}