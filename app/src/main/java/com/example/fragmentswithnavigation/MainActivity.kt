package com.example.fragmentswithnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController

const val ARG = "args"

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle = Bundle()
        bundle.putString(ARG, "Welcome")
        navController = findNavController(R.id.fragment)
        navController.setGraph(R.navigation.fragments_nav_graph, bundle)
    }
}
