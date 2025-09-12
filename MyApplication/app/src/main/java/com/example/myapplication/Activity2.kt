package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

// Referências aos botões e textos do Cao (exemplo, adapte os ids)
        val caoBtn = findViewById<ImageButton>(R.id.caoB)
        val caixaCao = findViewById<LinearLayout>(R.id.caixaCao)
        val caoV1 = findViewById<TextView>(R.id.caov1)
        val caoV2 = findViewById<TextView>(R.id.caov2)
        val caoV3 = findViewById<TextView>(R.id.caov3)
// Referências aos botões e textos do Gato
        val gatoBtn = findViewById<ImageButton>(R.id.gatoB)
        val caixaGato = findViewById<LinearLayout>(R.id.caixaGato)
        val gatoV1 = findViewById<TextView>(R.id.gatoV1)
        val gatoV2 = findViewById<TextView>(R.id.gatoV2)
        val gatoV3 = findViewById<TextView>(R.id.gatoV3)

// Referências aos botões e textos do Rato
        val ratoBtn = findViewById<ImageButton>(R.id.ratoB)
        val caixaRato = findViewById<LinearLayout>(R.id.caixaRato)
        val ratoV1 = findViewById<TextView>(R.id.ratoV1)
        val ratoV2 = findViewById<TextView>(R.id.ratoV2)
        val ratoV3 = findViewById<TextView>(R.id.ratoV3)


// Objetos das classes (supondo que já criou as classes Cao, Gato, Rato)
        val gato = Gato()
        val rato = Rato()
        val cao = Cao()

        // Função para esconder todos os grupos de texto
        fun alternarVisibilidadeCaixa(caixa: LinearLayout, textos: List<TextView>, conteudos: List<String>) {
            val visivel = caixa.visibility == View.VISIBLE


            if (visivel) {
                // Anima os textos para a esquerda (saída)
                val animacoes = textos.map { textView ->
                    textView.animate()
                        .alpha(0f)
                        .translationX(-100f)
                        .setDuration(200)
                }

                // Quando a última animação acabar, esconde a caixa e reseta propriedades
                animacoes.last().withEndAction {
                    caixa.visibility = View.INVISIBLE
                    textos.forEach {
                        it.alpha = 1f
                        it.translationX = 0f // reset para posição inicial
                    }
                }
            } else {
                // Mostrar textos com animação
                textos.forEachIndexed { index, textView ->
                    textView.text = conteudos[index]
                    textView.alpha = 0f
                    textView.translationX = -100f
                }
                caixa.alpha = 0f
                caixa.visibility = View.VISIBLE

                caixa.animate()
                    .alpha(1f)
                    .setDuration(400)
                    .start()

                textos.forEach { textView ->
                    textView.animate()
                        .alpha(1f)
                        .translationX(0f)
                        .setDuration(400)
                        .start()
                }
            }
        }

        caoBtn.setOnClickListener {
            alternarVisibilidadeCaixa(caixaCao, listOf(caoV1, caoV2, caoV3),
                listOf("Tipo: ${cao.tipo()}", "Come: ${cao.come()}", "Som: ${cao.som()}"))
        }

        gatoBtn.setOnClickListener {
            alternarVisibilidadeCaixa(caixaGato, listOf(gatoV1, gatoV2, gatoV3),
                listOf("Tipo: ${gato.tipo()}", "Come: ${gato.come()}", "Som: ${gato.som()}")
            )
        }

        ratoBtn.setOnClickListener {
            alternarVisibilidadeCaixa(caixaRato, listOf(ratoV1, ratoV2, ratoV3),
                listOf("Tipo: ${rato.tipo()}", "Come: ${rato.come()}", "Som: ${rato.som()}")
            )
        }

    }
}