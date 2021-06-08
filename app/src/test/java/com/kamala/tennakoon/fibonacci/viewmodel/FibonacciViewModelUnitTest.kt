package com.kamala.tennakoon.fibonacci.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kamala.tennakoon.fibonacci.model.FibonacciNumber
import com.kamala.tennakoon.fibonacci.utils.FibonacciGenerator
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*


@RunWith(MockitoJUnitRunner::class)
class FibonacciViewModelUnitTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var fibonacciGenerator: FibonacciGenerator

    private lateinit var fibonacciViewModel: FibonacciViewModel


    @Before
    fun setUp() {
        fibonacciViewModel = FibonacciViewModel(fibonacciGenerator)
    }

    @Test
    fun testGetFibonacciNumber() {
        val zeroFibonacciNumber = FibonacciNumber(fibonacciN1 = null, fibonacciN2 = null, result = 0)
        val firstFibonacciNumber = FibonacciNumber(fibonacciN1 = null, fibonacciN2 = null, result = 1)
        val secondFibonacciNumber = FibonacciNumber(fibonacciN1 = 0, fibonacciN2 = 1, result = 1)
        val thirdFibonacciNumber = FibonacciNumber(fibonacciN1 = 1, fibonacciN2 = 1, result = 2)
        whenever(fibonacciGenerator.getFibonacci(0)).thenReturn(zeroFibonacciNumber)
        whenever(fibonacciGenerator.getFibonacci(1)).thenReturn(firstFibonacciNumber)
        whenever(fibonacciGenerator.getFibonacci(2)).thenReturn(secondFibonacciNumber)
        whenever(fibonacciGenerator.getFibonacci(3)).thenReturn(thirdFibonacciNumber)

        fibonacciViewModel.getFibonacciNumber()
        then(fibonacciGenerator).should(times(1)).getFibonacci(0)
        Assert.assertEquals("0th fibonacci data should be set", zeroFibonacciNumber, fibonacciViewModel.fibonacci.value)

        fibonacciViewModel.getFibonacciNumber()
        then(fibonacciGenerator).should(times(1)).getFibonacci(1)
        Assert.assertEquals("1st fibonacci data should be set", firstFibonacciNumber, fibonacciViewModel.fibonacci.value)

        fibonacciViewModel.getFibonacciNumber()
        then(fibonacciGenerator).should(times(1)).getFibonacci(2)
        Assert.assertEquals("2nd fibonacci data should be set", secondFibonacciNumber, fibonacciViewModel.fibonacci.value)

        fibonacciViewModel.getFibonacciNumber()
        then(fibonacciGenerator).should(times(1)).getFibonacci(3)
        Assert.assertEquals("3rd fibonacci data should be set", thirdFibonacciNumber, fibonacciViewModel.fibonacci.value)
    }

    @Test
    fun testResetFibonacciNumber() {
        val anyFibonacciNumber = FibonacciNumber(fibonacciN1 = 1, fibonacciN2 = 1, result = 2)
        val zeroFibonacciNumber = FibonacciNumber(fibonacciN1 = null, fibonacciN2 = null, result = 0)
        whenever(fibonacciGenerator.getFibonacci(any())).thenReturn(anyFibonacciNumber)
        whenever(fibonacciGenerator.getFibonacci(0)).thenReturn(zeroFibonacciNumber)


        fibonacciViewModel.getFibonacciNumber()
        fibonacciViewModel.getFibonacciNumber()
        fibonacciViewModel.getFibonacciNumber()
        Assert.assertEquals("set have any of fibonacci", anyFibonacciNumber, fibonacciViewModel.fibonacci.value)

        fibonacciViewModel.resetFibonacciNumber()
        Assert.assertEquals("data reset to 0th fibonacci", zeroFibonacciNumber, fibonacciViewModel.fibonacci.value)
    }
}