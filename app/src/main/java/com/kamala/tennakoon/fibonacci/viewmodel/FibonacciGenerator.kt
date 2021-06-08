package com.kamala.tennakoon.fibonacci.viewmodel

import com.kamala.tennakoon.fibonacci.model.FibonacciNumber

class FibonacciGenerator {

    public fun getFibonacci(index: Int): FibonacciNumber? {
        if(index < 0) return null
        if (index < 2) return FibonacciNumber(fibonacciN1 = null, fibonacciN2 = null, result = index)

        val fibonacciN1Info = getFibonacci(index = index - 2)
        val fibonacciN2Info = getFibonacci(index = index - 1)

        val result = fibonacciN2Info!!.result + fibonacciN1Info!!.result
        return FibonacciNumber(
            fibonacciN1 = fibonacciN1Info.result,
            fibonacciN2 = fibonacciN2Info.result,
            result = result
        )
    }
}