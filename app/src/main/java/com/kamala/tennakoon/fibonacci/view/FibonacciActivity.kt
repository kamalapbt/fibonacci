package com.kamala.tennakoon.fibonacci.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kamala.tennakoon.fibonacci.databinding.ActivityMainBinding
import com.kamala.tennakoon.fibonacci.model.FibonacciNumber
import com.kamala.tennakoon.fibonacci.viewmodel.FibonacciGenerator
import com.kamala.tennakoon.fibonacci.viewmodel.FibonacciViewModel
import com.kamala.tennakoon.fibonacci.viewmodel.ViewModelFactory


class FibonacciActivity : AppCompatActivity() {
    private lateinit var viewModel: FibonacciViewModel
    private lateinit var viewbinding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(FibonacciGenerator())
        ).get(FibonacciViewModel::class.java)
        viewbinding.nextFibonacciButton.setOnClickListener {
            viewModel.onClickGetNextFibonacci()
        }

        setFibonacciDetail()
    }

    fun setFibonacciDetail() {
        val nameObserver = Observer<FibonacciNumber> { currentFibonacci ->
            if (currentFibonacci.fibonacciN1 != null && currentFibonacci.fibonacciN2 != null) {
                viewbinding.fibonacciTextView.text =
                    "${currentFibonacci.result} = ${currentFibonacci.fibonacciN1} + ${currentFibonacci.fibonacciN2}"
            } else {
                viewbinding.fibonacciTextView.text = "${currentFibonacci.result}"
            }
        }
        viewModel.fibonacci.observe(this, nameObserver)
    }
}