package com.cs407.calculatorapp
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val result = intent.getStringExtra("result")?.toDouble() ?: 0.0

        resultTextView.text = "Result: ${result.toDouble()}"
    }
}




