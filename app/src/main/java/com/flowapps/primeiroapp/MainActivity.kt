package com.flowapps.primeiroapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constrainLayout)) { v, insets ->
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

        val btSend = findViewById<Button>(R.id.btSend)
        val btClear = findViewById<Button>(R.id.btClear)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)

        btSend.setOnClickListener {
            if (etName.text.isEmpty()) {
                etName.error = "Um E-mail deve ser inserido"
            } else {
                tvResult.text = etName.text.toString()
                Toast.makeText(this, "Atualizado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        btClear.setOnClickListener {

            val oldText = tvResult.text

            etName.text.clear()
            tvResult.text = ""

            val constrainLayout = findViewById<ConstraintLayout>(R.id.constrainLayout)
            Snackbar.make(constrainLayout, "Limpado com sucesso", Snackbar.LENGTH_INDEFINITE).setAction("Desfazer") {
                tvResult.text = oldText
                etName.setText(oldText)
                Toast.makeText(this, "Texto revertido", Toast.LENGTH_SHORT).show()
            }.show()
        }

    }
}