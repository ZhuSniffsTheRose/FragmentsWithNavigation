package com.example.fragmentswithnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {
    private var arg: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arg = requireArguments().getString(ARG)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val enterName = view?.findViewById<EditText>(R.id.enterName)
        enterName?.hint = arg
        view?.findViewById<Button>(R.id.home_btn)?.setOnClickListener {
            val name = enterName?.text.toString()
            if (name.isEmpty()) {
                enterName?.error = "Please enter a name"
            } else {

                val actionHomeFragmentToSecondFragment =
                    HomeFragmentDirections.actionHomeFragmentToSecondFragment()
                actionHomeFragmentToSecondFragment.setName(name)
                findNavController().navigate(actionHomeFragmentToSecondFragment)
            }

        }
    }
}
