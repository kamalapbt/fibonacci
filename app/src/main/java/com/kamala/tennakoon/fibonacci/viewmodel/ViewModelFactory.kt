package com.kamala.tennakoon.fibonacci.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kamala.tennakoon.fibonacci.utils.FibonacciGenerator


class ViewModelFactory(
    private val fibonacciGenarator: FibonacciGenerator
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FibonacciViewModel(fibonacciGenarator) as T
    }

}
