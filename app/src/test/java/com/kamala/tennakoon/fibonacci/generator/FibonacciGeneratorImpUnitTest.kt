package com.kamala.tennakoon.fibonacci.generator

import com.kamala.tennakoon.fibonacci.model.FibonacciNumber
import org.junit.Assert
import org.junit.Test

class FibonacciGeneratorImpUnitTest {
    private val fibonacciGenerator: FibonacciGeneratorImp = FibonacciGeneratorImp()

    @Test
    fun testGetFibonacci() {
        val zeroIndexExpectedValue = FibonacciNumber(result = 0, fibonacciN1 = null, fibonacciN2 = null)
        Assert.assertEquals("0th fibonacci number", zeroIndexExpectedValue, fibonacciGenerator.getFibonacci(index=0) )

        Assert.assertNull("negative int fibonacci number", fibonacciGenerator.getFibonacci(index=-4) )

        val thirdIndexExpectedValue = FibonacciNumber(result = 2, fibonacciN1 = 1, fibonacciN2 = 1)
        Assert.assertEquals("3rd fibonacci number", thirdIndexExpectedValue, fibonacciGenerator.getFibonacci(index=3) )

        val tenIndexExpectedValue = FibonacciNumber(result = 55, fibonacciN1 = 21, fibonacciN2 = 34)
        Assert.assertEquals("10th fibonacci number", tenIndexExpectedValue, fibonacciGenerator.getFibonacci(index=10) )

        val towentyIndexExpectedValue = FibonacciNumber(result = 6765, fibonacciN1 = 2584, fibonacciN2 = 4181)
        Assert.assertEquals("20th fibonacci number", towentyIndexExpectedValue, fibonacciGenerator.getFibonacci(index=20) )
    }
}