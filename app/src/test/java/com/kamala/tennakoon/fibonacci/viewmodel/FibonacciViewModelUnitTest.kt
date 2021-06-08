package com.kamala.tennakoon.fibonacci.viewmodel

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.*

class FibonacciViewModelUnitTest {
    @Mock
    val mockFibonacciGenerator: FibonacciGenerator = mock()

    private val fibonacciViewModel: FibonacciViewModel = FibonacciViewModel(mockFibonacciGenerator);

    @Test
    fun testGetFibonacci() {
    }

    @Test
    fun testOnClickGetNextFibonacci() {
        Mockito.`when`(fibonacciViewModel.onClickGetNextFibonacci())
            .thenCallRealMethod()
//        verify(mockFibonacciGenerator, times(1)).getFibonacci(1)
    }
}