package com.example.jogodavelha

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class tela_resultado : AppCompatActivity() {

    // Guardar jogadas
    private var jogoEncerrado = false
    private var jogador1 = ArrayList<Int>()
    private var jogador2 = ArrayList<Int>()

    // Vez do jogador
    private var activejogador = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Inicialize os botões e defina o clique
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)

        // Defina a função de clique para cada botão
        button1.setOnClickListener { btClick(it) }
        button2.setOnClickListener { btClick(it) }
        button3.setOnClickListener { btClick(it) }
        button4.setOnClickListener { btClick(it) }
        button5.setOnClickListener { btClick(it) }
        button6.setOnClickListener { btClick(it) }
        button7.setOnClickListener { btClick(it) }
        button8.setOnClickListener { btClick(it) }
        button9.setOnClickListener { btClick(it) }
    }

    fun btClick(view: View) {
        val btSelecionado = view as Button
        var QuadradoID = 0

        when (btSelecionado.id) {
            R.id.button1 -> QuadradoID = 1
            R.id.button2 -> QuadradoID = 2
            R.id.button3 -> QuadradoID = 3
            R.id.button4 -> QuadradoID = 4
            R.id.button5 -> QuadradoID = 5
            R.id.button6 -> QuadradoID = 6
            R.id.button7 -> QuadradoID = 7
            R.id.button8 -> QuadradoID = 8
            R.id.button9 -> QuadradoID = 9
        }

        // Iniciar o jogo com a jogada selecionada
        inicioJogo(QuadradoID, btSelecionado)
    }

    fun inicioJogo(QuadradoID: Int, btSelecionado: Button) {
        if (jogoEncerrado) return
        if (activejogador == 1) {
            btSelecionado.text = "X"
            btSelecionado.setTextColor(Color.BLACK)
            btSelecionado.textSize = 24f
                btSelecionado.setBackgroundColor(Color.parseColor("#be2929"))
            jogador1.add(QuadradoID)
            activejogador = 2
        } else {
            btSelecionado.text = "O"
            btSelecionado.setTextColor(Color.WHITE)
            btSelecionado.textSize = 24f
            btSelecionado.setBackgroundColor(Color.parseColor("#006494"))
            jogador2.add(QuadradoID)
            activejogador = 1
        }
        btSelecionado.isEnabled = false
        verificarGanhador()
    }

    fun verificarGanhador() {
        var ganhador = -1

        // Validações para jogador 1
        if (jogador1.contains(1) && jogador1.contains(2) && jogador1.contains(3)) {
            ganhador = 1
        } else if (jogador1.contains(4) && jogador1.contains(5) && jogador1.contains(6)) {
            ganhador = 1
        } else if (jogador1.contains(7) && jogador1.contains(8) && jogador1.contains(9)) {
            ganhador = 1
        } else if (jogador1.contains(1) && jogador1.contains(4) && jogador1.contains(7)) {
            ganhador = 1
        } else if (jogador1.contains(2) && jogador1.contains(5) && jogador1.contains(8)) {
            ganhador = 1
        } else if (jogador1.contains(3) && jogador1.contains(6) && jogador1.contains(9)) {
            ganhador = 1
        } else if (jogador1.contains(1) && jogador1.contains(5) && jogador1.contains(9)) {
            ganhador = 1
        } else if (jogador1.contains(3) && jogador1.contains(5) && jogador1.contains(7)) {
            ganhador = 1
        }

        // Validações para jogador 2
        else if (jogador2.contains(1) && jogador2.contains(2) && jogador2.contains(3)) {
            ganhador = 2
        } else if (jogador2.contains(4) && jogador2.contains(5) && jogador2.contains(6)) {
            ganhador = 2
        } else if (jogador2.contains(7) && jogador2.contains(8) && jogador2.contains(9)) {
            ganhador = 2
        } else if (jogador2.contains(1) && jogador2.contains(4) && jogador2.contains(7)) {
            ganhador = 2
        } else if (jogador2.contains(2) && jogador2.contains(5) && jogador2.contains(8)) {
            ganhador = 2
        } else if (jogador2.contains(3) && jogador2.contains(6) && jogador2.contains(9)) {
            ganhador = 2
        } else if (jogador2.contains(1) && jogador2.contains(5) && jogador2.contains(9)) {
            ganhador = 2
        } else if (jogador2.contains(3) && jogador2.contains(5) && jogador2.contains(7)) {
            ganhador = 2
        }

        // Verifica se há um ganhador
        if (ganhador != -1) {
            if (ganhador == 1) {
                Toast.makeText(this, "Jogador 1 venceu!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Jogador 2 venceu!", Toast.LENGTH_SHORT).show()
            }
            jogoEncerrado = true
        }
    }
}