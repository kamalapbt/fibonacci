package com.kamala.tennakoon.fibonacci.utils

import com.kamala.tennakoon.fibonacci.model.FibonacciNumber

interface FibonacciSeries {
    fun getFibonacci(index: Int): FibonacciNumber?

}