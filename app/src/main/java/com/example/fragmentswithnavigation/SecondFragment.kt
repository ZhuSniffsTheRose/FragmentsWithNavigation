package com.example.fragmentswithnavigation

import android.os.Bundle
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.fragmentswithnavigation.base.AbsViewBindingFragment
import com.example.fragmentswithnavigation.databinding.FragmentSecondBinding


class SecondFragment : AbsViewBindingFragment<FragmentSecondBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {}
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewBinding.welcomeWithNameTv.text = SecondFragmentArgs.fromBundle(requireArguments()).name
        mViewBinding.secondBtn.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_homeFragment)
        }
    }


    override fun initViewBinding(): FragmentSecondBinding =
        FragmentSecondBinding.inflate(layoutInflater)
}
