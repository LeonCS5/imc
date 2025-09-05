package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.red

class MainActivity : AppCompatActivity() {
    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResultado: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editTextPeso = findViewById(R.id.editTextPeso)
        editTextAltura = findViewById(R.id.editTextAltura)
        buttonCalcular = findViewById(R.id.buttonCalcular)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonCalcular.setOnClickListener{
            val Peso = editTextPeso.text.toString().toDouble()
            val Altura = editTextAltura.text.toString().toDouble()
            val IMC = Peso / ((Altura / 100) * (Altura / 100))

        button.setOnClickListener{
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

            if (IMC < 18.5){
                textViewResultado.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan))
            } else if (IMC >= 18.5 && IMC <= 24.9){
                textViewResultado.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            } else if (IMC > 24.9 && IMC <= 29.9){
                textViewResultado.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
            } else if (IMC >29.9 && IMC <= 34.9){
                textViewResultado.setBackgroundColor(ContextCompat.getColor(this, R.color.tomato))
            } else if (IMC >34.9 && IMC <= 39.9){
                textViewResultado.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            } else{
                textViewResultado.setBackgroundColor(ContextCompat.getColor(this, R.color.bloodred))
            }

            val imcFormatted = String.format("%.2f",IMC)
            textViewResultado.text = "Seu IMC é: $imcFormatted"

        }
    }
}
