package com.example.fragmentswithnavigation

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.fragmentswithnavigation.base.AbsViewBindingFragment
import com.example.fragmentswithnavigation.databinding.FragmentHomeBinding


class HomeFragment : AbsViewBindingFragment<FragmentHomeBinding>() {

    private var arg: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arg = requireArguments().getString(ARG)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewBinding.enterName.hint = arg
        mViewBinding.homeBtn.setOnClickListener {
            val name = mViewBinding.enterName.text.toString()
            if (name.isEmpty()) {
                mViewBinding.enterName.error = "Please enter a name"
            } else {

                val actionHomeFragmentToSecondFragment =
                    HomeFragmentDirections.actionHomeFragmentToSecondFragment(name)
                findNavController().navigate(actionHomeFragmentToSecondFragment)
            }

        }
    }

    override fun initViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)
}
