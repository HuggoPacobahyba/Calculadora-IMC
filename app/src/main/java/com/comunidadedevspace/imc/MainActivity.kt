package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtPeso = findViewById<TextInputEditText>(R.id._edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btn_Calcular = findViewById<Button>(R.id.btn_calcular)


        btn_Calcular.setOnClickListener(){
            val peso = edtPeso.text
            val altura = edtAltura.text
            println("Huggo " + peso + altura)

        }


    }
}