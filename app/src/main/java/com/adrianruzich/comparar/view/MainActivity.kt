package com.adrianruzich.comparar.view

import com.adrianruzich.comparar.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.activity.viewModels
import com.adrianruzich.comparar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparador.observe(this) {
            binding.resultado.text =
                if (it.iguales) {
                    getString(R.string.textosIguales)
                }
                else {
                    getString(R.string.textosDistintos)
                }
        }

        binding.boton.setOnClickListener {
            mainViewModel.compararCadenas(
                findViewById<EditText>(R.id.entrada1).text.toString(),
                findViewById<EditText>(R.id.entrada2).text.toString()
            )
        }
    }
}
