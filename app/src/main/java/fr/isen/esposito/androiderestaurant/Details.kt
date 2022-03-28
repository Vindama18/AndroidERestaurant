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
import android.widget.Toast
import com.squareup.picasso.Picasso

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
        val price = item.prices[0].price + "€"
        binding.dishprice.text = price
        binding.imageView2.adapter = ViewPageAdapter(this, item.images)



        binding.dishdescription.text = item.ingredients.joinToString(", ", transform = { it.name_fr })

        Log.i("image", item.images.toString())
        //binding.viewSilder.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //binding.viewSilder.adapter = ViewAdapter(this,item.images)
        binding.addBtn.text = "Total $price"
        binding.addBtn.setOnClickListener {
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show()
        }

        binding.btnMinus.setOnClickListener {
            val value = binding.quantityText.text.toString()
            val increase = value.toInt() -  1
            if ( increase >= 0){
                binding.quantityText.text = increase.toString()
                val pricee = item.prices[0].price.toInt() * increase
                binding.addBtn.text = "Total $pricee €"
            }
        }
        binding.btnUp.setOnClickListener {
            val value = binding.quantityText.text.toString()
            val increase = value.toInt() + 1
            if ( increase >= 0){
                binding.quantityText.text = increase.toString()
                val pricee = item.prices[0].price.toInt() * increase
                binding.addBtn.text = "Total $pricee €"
            }
        }

    }
}