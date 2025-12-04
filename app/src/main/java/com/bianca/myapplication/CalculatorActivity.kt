package com.bianca.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput = ""
    private var lastValue = 0.0
    private var lastOperator = ""
    private var isOperatorPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // BACK BUTTON
        findViewById<ImageView>(R.id.btnBack).setOnClickListener { finish() }

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

        // Operators
        findViewById<Button>(R.id.btnPlus).setOnClickListener { onOperatorClick("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { onOperatorClick("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { onOperatorClick("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { onOperatorClick("/") }

        findViewById<Button>(R.id.btnDot).setOnClickListener { onDotClick() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearAll() }
        findViewById<Button>(R.id.btnDelete).setOnClickListener { deleteLast() }
        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateFinal() }
    }

    // FORMATTER — removes ".0" but keeps decimals if needed
    private fun formatNumber(value: Double): String {
        return if (value % 1 == 0.0) {
            value.toInt().toString()
        } else {
            value.toString()
        }
    }

    private fun onNumberClick(num: String) {
        if (isOperatorPressed) {
            currentInput = ""
            isOperatorPressed = false
        }

        currentInput += num
        display.text = currentInput
    }

    private fun onDotClick() {
        if (!currentInput.contains(".")) {
            currentInput = if (currentInput.isEmpty()) "0." else "$currentInput."
            display.text = currentInput
        }
    }

    private fun onOperatorClick(op: String) {
        if (currentInput.isEmpty()) {
            lastOperator = op
            return
        }

        if (lastOperator.isEmpty()) {
            lastValue = currentInput.toDouble()
        } else {
            lastValue = performOperation(lastValue, currentInput.toDouble(), lastOperator)
        }

        lastOperator = op
        isOperatorPressed = true

        display.text = "${formatNumber(lastValue)} $op"
    }

    private fun performOperation(a: Double, b: Double, op: String): Double {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b == 0.0) 0.0 else a / b
            else -> b
        }
    }

    private fun calculateFinal() {
        if (currentInput.isEmpty() || lastOperator.isEmpty()) return

        val result = performOperation(lastValue, currentInput.toDouble(), lastOperator)

        // display final formatted result
        display.text = formatNumber(result)

        // prepare for next chain
        lastValue = result
        currentInput = formatNumber(result)
        lastOperator = ""
    }

    private fun clearAll() {
        currentInput = ""
        lastValue = 0.0
        lastOperator = ""
        isOperatorPressed = false
        display.text = "0"
    }

    private fun deleteLast() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            display.text = if (currentInput.isEmpty()) "0" else currentInput
        }
    }
}
