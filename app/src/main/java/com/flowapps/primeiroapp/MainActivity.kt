package com.flowapps.primeiroapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Comportamentos serão declarados aqui
        // Encontrar os elementos de interface
        // <> -> Tipo da informação
        // () -> ID da informação (R.id.tvResult etc)
        // val -> não muda de valor
        // var -> mudam de valor

        val btSend = findViewById<Button>(R.id.btSend);
        val tvResult = findViewById<TextView>(R.id.tvResult);

        btSend.setOnClickListener {
            tvResult.text = "O botão foi clicado"
        }
    }


}