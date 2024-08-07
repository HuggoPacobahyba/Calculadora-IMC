package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tv_result = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tv_result.text = result.toString()

        val (classificacao:String, color:Int ) = when {
            result <= 18.5 -> {
                "MAGREZA" to R.color.MAGREZA
            }

            result > 18.5f && result <= 24.9f -> {
                "NORMAL" to R.color.NORMAL

            }

            result > 25 && result <= 29.9 -> {
                "SOBREPESO" to R.color.SOBREPESO
            }

            result > 30 && result <= 39.9 -> {
                "OBESIDADE" to R.color.OBESIDADE
            }

            else -> {
                "OBESIDADE GRAVE" to R.color.OBESIDADE_GRAVE
            }

        }

        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))
        tvClassificacao.text = classificacao
                //Text = classificacao

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}