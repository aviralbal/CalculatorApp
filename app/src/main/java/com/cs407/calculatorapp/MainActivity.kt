package com.cs407.calculatorapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.editTextNumber1)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton.setOnClickListener {
            operate(num1, num2) { a, b -> a + b }
        }
        subtractButton.setOnClickListener {
            operate(num1, num2) { a, b -> a - b }
        }
        multiplyButton.setOnClickListener {
            operate(num1, num2) { a, b -> a * b }
        }
        divideButton.setOnClickListener {
            if (num2.text.toString() == "0") {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
            } else {
                operate(num1, num2) { a, b -> a / b }
            }
        }
    }

    private fun operate(num1: EditText, num2: EditText, operation: (Int, Int) -> Int) {
        val number1 = num1.text.toString().toInt()
        val number2 = num2.text.toString().toInt()
        val result = operation(number1, number2)
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("result", result.toString())
        }
        startActivity(intent)
    }
}
