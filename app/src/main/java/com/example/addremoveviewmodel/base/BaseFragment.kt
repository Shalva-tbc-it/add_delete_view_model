package com.example.addremoveviewmodel.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflater<T> = (LayoutInflater, ViewGroup, Boolean) -> T
abstract class BaseFragment<VB: ViewBinding>(private val inflate: Inflater<VB>) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = inflate.invoke(inflater, container!!, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start()
        clickListener()
        bindObserve()
    }

    abstract fun start()
    abstract fun clickListener()
    abstract fun bindObserve()


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}