package com.example.distrib

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Math.exp
import java.lang.Math.sqrt
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var meanEditText: EditText
    private lateinit var varianceEditText: EditText
    private lateinit var getNumButton: Button
    private lateinit var resultTextView: TextView

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meanEditText = findViewById(R.id.mean_val)
        varianceEditText = findViewById(R.id.variance_value)
        getNumButton = findViewById(R.id.get_random_num)
        resultTextView = findViewById(R.id.random_number_result)

        // Получить ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Загрузить сохраненное число, если оно есть
        val savedNumber = viewModel.savedNumber
        if (savedNumber != null) {
            resultTextView.text = savedNumber.toString()
        }

        getNumButton.setOnClickListener {
            if (meanEditText.text.isNotEmpty() && varianceEditText.text.isNotEmpty()) {
                val mean = meanEditText.text.toString().toDouble()
                val variance = varianceEditText.text.toString().toDouble()
                val num = getLogNormalRandomValue(mean, variance)
                resultTextView.text = num.toString()

                // Сохранить число в ViewModel
                viewModel.savedNumber = num
            }
        }
    }

    fun getLogNormalRandomValue(mean: Double, variance: Double): Double {
        val standardNormalRandomValue = Random().nextGaussian()
        return exp(mean + variance / 2.0) * exp(standardNormalRandomValue * sqrt(variance))
    }
}

class MainViewModel : ViewModel() {
    var savedNumber: Double? = null
}
