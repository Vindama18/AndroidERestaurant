package fr.isen.esposito.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(activity: AppCompatActivity, private val image :List<String>) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return image.size
    }

    override fun createFragment(position: Int): Fragment {
        return  MenuFragment(image[position].ifEmpty { null })
    }
}