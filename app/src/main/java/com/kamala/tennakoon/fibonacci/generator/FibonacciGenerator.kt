package com.kamala.tennakoon.fibonacci.generator

import com.kamala.tennakoon.fibonacci.model.FibonacciNumber

interface FibonacciGenerator {
    fun getFibonacci(index: Int): FibonacciNumber?

}