package com.kamala.tennakoon.fibonacci.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamala.tennakoon.fibonacci.model.FibonacciNumber
import com.kamala.tennakoon.fibonacci.utils.FibonacciGenerator

class FibonacciViewModel(
    private val fibonacciGenarator: FibonacciGenerator
) : ViewModel() {
    private var index = -1
    val fibonacci: MutableLiveData<FibonacciNumber> by lazy {
        MutableLiveData<FibonacciNumber>()
    }

    fun getFibonacciNumber() {
        index += 1
        fibonacci.value = fibonacciGenarator.getFibonacci(index)
    }
    fun resetFibonacciNumber() {
        index = 0
        fibonacci.value = fibonacciGenarator.getFibonacci(index)
    }
}