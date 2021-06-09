package com.kamala.tennakoon.fibonacci.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamala.tennakoon.fibonacci.generator.FibonacciGenerator
import com.kamala.tennakoon.fibonacci.model.FibonacciNumber

class FibonacciViewModel(
    private val fibonacciGenarator: FibonacciGenerator
) : ViewModel() {
    private var index = 0
    val fibonacci: MutableLiveData<FibonacciNumber> by lazy {
        MutableLiveData<FibonacciNumber>()
    }
    fun getCurrentIndex(): Int = index
    fun getFibonacciNumber(index: Int) {
        this.index = index
        fibonacci.value = fibonacciGenarator.getFibonacci(this.index)
    }
    fun resetFibonacciNumber() {
        getFibonacciNumber(0)
    }
}