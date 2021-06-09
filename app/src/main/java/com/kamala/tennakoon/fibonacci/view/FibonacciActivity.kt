package com.kamala.tennakoon.fibonacci.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kamala.tennakoon.fibonacci.R
import com.kamala.tennakoon.fibonacci.databinding.ActivityMainBinding
import com.kamala.tennakoon.fibonacci.model.FibonacciNumber
import com.kamala.tennakoon.fibonacci.generator.FibonacciGeneratorImp
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
            ViewModelFactory(FibonacciGeneratorImp())
        ).get(FibonacciViewModel::class.java)
        viewbinding.nextFibonacciButton.setOnClickListener {
            viewModel.getFibonacciNumber(viewModel.getCurrentIndex() + 1)
        }
        viewModel.getFibonacciNumber(viewModel.getCurrentIndex())
        setFibonacciDetail()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_restore -> {
                viewModel.resetFibonacciNumber()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun setFibonacciDetail() {
        val nameObserver = Observer<FibonacciNumber> { currentFibonacci ->
            if (currentFibonacci.fibonacciN1 != null && currentFibonacci.fibonacciN2 != null) {
                viewbinding.fibonacciCalculationTextView.text =
                    "${currentFibonacci.fibonacciN1} + ${currentFibonacci.fibonacciN2}"
            } else {
                viewbinding.fibonacciCalculationTextView.text = ""
            }
                viewbinding.fibonacciTextView.text = "${currentFibonacci.result}"

        }
        viewModel.fibonacci.observe(this, nameObserver)
    }
}