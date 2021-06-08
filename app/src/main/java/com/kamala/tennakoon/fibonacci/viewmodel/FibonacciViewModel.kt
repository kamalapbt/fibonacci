package com.kamala.tennakoon.fibonacci.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamala.tennakoon.fibonacci.model.FibonacciNumber

class FibonacciViewModel(
    private val fibonacciGenarator: FibonacciGenerator
) : ViewModel() {
    private var index = 0
    val fibonacci: MutableLiveData<FibonacciNumber> by lazy {
        MutableLiveData<FibonacciNumber>()
    }

    init {
        fibonacci.value = fibonacciGenarator.getFibonacci(index)
    }

    fun onClickGetNextFibonacci() {
        index = index + 1
        fibonacci.value = fibonacciGenarator.getFibonacci(index)
    }
}