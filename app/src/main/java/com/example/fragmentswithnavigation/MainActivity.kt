package com.example.fragmentswithnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentswithnavigation.databinding.ActivityMainBinding

const val ARG = "args"

/**
 * The root element of the layout is always stored in a property called root which is generated automatically for you.
 * In an Activity’s onCreate method you pass root to setContentView to tell the Activity to use the layout from the binding object.
 *
 *  When using view binding in an Activity, you should always pass the layout from the binding object with setContentView(binding.root).
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = Bundle()
        bundle.putString(ARG, "Welcome")
        navController = findNavController(R.id.fragment)
        navController.setGraph(R.navigation.fragments_nav_graph, bundle)
    }

    fun check(view: View) {
        if (isForeground(HomeFragment::class.java)) {
            Toast.makeText(this, "I'm HomeFragment", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "I'm not HomeFragment", Toast.LENGTH_SHORT).show()
        }
    }


    @Suppress("UNCHECKED_CAST")
    fun <F : Fragment> isForeground(fragmentClass: Class<F>): Boolean {
        var currentFragment: Fragment? = null
        val navHostFragment = this.supportFragmentManager.fragments.first() as NavHostFragment
        navHostFragment.childFragmentManager.fragments.forEach {
            if (fragmentClass.isAssignableFrom(it.javaClass)) {
                currentFragment = it as F
            }
        }
        return currentFragment != null
    }
}
