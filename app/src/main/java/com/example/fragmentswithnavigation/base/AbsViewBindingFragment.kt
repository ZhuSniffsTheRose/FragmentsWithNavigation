package com.example.fragmentswithnavigation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class AbsViewBindingFragment<V : ViewBinding> : Fragment() {
    var mViewBinding by autoCleared<V>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = initViewBinding()
        return mViewBinding.root
    }

    abstract fun initViewBinding(): V

}