package com.bianca.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput = ""
    private var storedNumber = ""
    private var operator = ""
    private var resultShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        // BACK BUTTON
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        display = findViewById(R.id.tvDisplay)

        // Number buttons
        val numbers = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        for (id in numbers) {
            findViewById<Button>(id).setOnClickListener {
                onNumberClick((it as Button).text.toString())
            }
        }

        // Operator buttons
        findViewById<Button>(R.id.btnPlus).setOnClickListener { onOperatorClick("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { onOperatorClick("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { onOperatorClick("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { onOperatorClick("/") }

        // Dot button
        findViewById<Button>(R.id.btnDot).setOnClickListener { onDotClick() }

        // Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearAll() }

        // Equals
        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }
    }

    private fun onNumberClick(num: String) {
        if (resultShown) {
            currentInput = ""
            resultShown = false
        }
        currentInput += num
        updateDisplay()
    }

    private fun onDotClick() {
        if (resultShown) {
            currentInput = ""
            resultShown = false
        }
        if (!currentInput.contains(".")) {
            currentInput += if (currentInput.isEmpty()) "0." else "."
            updateDisplay()
        }
    }

    private fun onOperatorClick(op: String) {
        if (currentInput.isEmpty()) return

        storedNumber = currentInput
        currentInput = ""
        operator = op
        updateDisplay()
    }

    private fun calculateResult() {
        if (storedNumber.isEmpty() || currentInput.isEmpty()) return

        val num1 = storedNumber.toDouble()
        val num2 = currentInput.toDouble()
        var result = 0.0

        result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 == 0.0) {
                    display.text = "Error"
                    return
                } else num1 / num2
            }
            else -> return
        }

        display.text = result.toString().removeSuffix(".0")
        currentInput = result.toString()
        storedNumber = ""
        operator = ""
        resultShown = true
    }

    private fun clearAll() {
        currentInput = ""
        storedNumber = ""
        operator = ""
        resultShown = false
        display.text = "0"
    }

    private fun updateDisplay() {
        display.text =
            if (currentInput.isEmpty()) "0"
            else currentInput
    }
}
