package com.example.indexmassbody

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var textView:TextView
    private lateinit var imageView: ImageView
    private lateinit var textViewScroll: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView=findViewById(R.id.textView)
        imageView=findViewById(R.id.imageView)
        textViewScroll=findViewById(R.id.textViewScroll)

        val resultString = intent.getStringExtra("result")!!
        textView.text="Индекс тела = $resultString"

        val index=resultString.replace(",",".").toDouble()  //вот тут ошибка преобразования

        when (index) {
            in 0.0..18.9 ->{
                imageView.setImageResource (R.drawable.ind18)
                textViewScroll.setText(R.string.index19)
            }
            in 19.0..24.0 ->{
                imageView.setImageResource (R.drawable.ind24)
                textViewScroll.setText(R.string.index19_24)
            }
            in 24.0..30.0 ->{
                imageView.setImageResource (R.drawable.ind35)
                textViewScroll.setText(R.string.index24_30)
            }
            in 30.1..70.0 ->{
                imageView.setImageResource (R.drawable.ind35)
                textViewScroll.setText(R.string.index30)
            }
        }


    }
}