package com.example.indexmassbody

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText1=findViewById(R.id.editText1)
        editText2=findViewById(R.id.editText2)
        button=findViewById(R.id.button)

        button.setOnClickListener {

            val massa=editText1.text.toString().trim().toDouble()
            val height=editText2.text.toString().trim().toDouble()
            //val result= (massa / (height / 100 * height / 100)).toString()
            val result = String.format("%.1f",massa / (height / 100 * height / 100))
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}