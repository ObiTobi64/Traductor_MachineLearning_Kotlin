package com.example.traductorml_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.traductorml_kotlin.Modelo.Idioma
import com.google.android.material.button.MaterialButton
import com.google.mlkit.nl.translate.TranslateLanguage
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var Et_Idioma_Origen : EditText
    private lateinit var Tv_Idioma_Destino : TextView
    private lateinit var Btn_Elegir_Idioma : MaterialButton
    private lateinit var Btn_Idioma_Elegido : MaterialButton
    private lateinit var Btn_Traducir : MaterialButton

    private var IdiomaArrayList :ArrayList<Idioma> ?= null

    companion object {
        private const val REGISTRO = "Mis registros"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InicializarVistas()
        IdiomasDisponibles()

        Btn_Elegir_Idioma.setOnClickListener {
            Toast.makeText(applicationContext,"Elegir Idioma", Toast.LENGTH_SHORT).show()
        }

        Btn_Idioma_Elegido.setOnClickListener {
            Toast.makeText(applicationContext,"Idioma elegido", Toast.LENGTH_SHORT).show()

        }

        Btn_Traducir.setOnClickListener {
            Toast.makeText(applicationContext,"Traducir", Toast.LENGTH_SHORT).show()

        }


    }

    private fun InicializarVistas(){
        Et_Idioma_Origen = findViewById(R.id.Et_Idioma_Origen)
        Tv_Idioma_Destino = findViewById(R.id.Tv_Idioma_Destino)
        Btn_Elegir_Idioma = findViewById(R.id.Btn_Elegir_Idioma)
        Btn_Idioma_Elegido = findViewById(R.id.Btn_Idioma_Elegido)
        Btn_Traducir = findViewById(R.id.Btn_Traducir)
    }

    private fun IdiomasDisponibles(){
        IdiomaArrayList = ArrayList()

        val ListaCodigoIdioma = TranslateLanguage.getAllLanguages()

        //es - Español
        for(codigo_lenguaje in ListaCodigoIdioma){
            val titulo_lenguaje = Locale(codigo_lenguaje).displayLanguage

            Log.d(REGISTRO,"IdiomasDisponibles: codigo_lenguaje $codigo_lenguaje")
            Log.d(REGISTRO,"IdiomasDisponibles: titulo_lenguaje $titulo_lenguaje")

            val modeloIdioma = Idioma(codigo_lenguaje,titulo_lenguaje)

            IdiomaArrayList!!.add(modeloIdioma)
        }
    }
}