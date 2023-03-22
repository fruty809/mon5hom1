package com.example.mon5hom1

import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.mon5hom1.databinding.ActivityMainBinding

interface CounterView {
    fun updateCount(count: Int)
    fun showCongratulations()
    fun changeTextColorToGreen()
    fun changeTextColorToDefault()
}


class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var presenter: CounterPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CounterPresenterImpl(this)

        binding.plusButton.setOnClickListener {
            presenter.onPlusButtonClicked()
        }

        binding.minusButton.setOnClickListener {
            presenter.onMinusButtonClicked()
        }
    }

    override fun updateCount(count: Int) {
        binding.countTextView.text = count.toString()
    }

    override fun showCongratulations() {
        Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColorToGreen() {
        binding.countTextView.setTextColor(ContextCompat.getColor(this, R.color.green))
    }

    override fun changeTextColorToDefault() {
        binding.countTextView.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
}