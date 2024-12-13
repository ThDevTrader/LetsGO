package com.thdev.letsgo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.thdev.letsgo.data.DriverOption
import com.thdev.letsgo.data.Review
import com.thdev.letsgo.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }


    private fun initRecyclerView() {
        binding.optionsList.layoutManager = LinearLayoutManager(this)
        binding.optionsList.setHasFixedSize(true)
        binding.optionsList.adapter = AdapterDrivers(getList())

        binding.optionsList.visibility = View.GONE

        Handler(Looper.getMainLooper()).postDelayed({
            binding.optionsList.visibility = View.VISIBLE },
            2000)
    }

    private fun getList(): ArrayList<DriverOption> {
        return arrayListOf(
            DriverOption(
                1,
                "Homer Simpson",
                "Olá! Sou o Homer, seu motorista camarada! Relaxe e aproveite o passeio, com direito a rosquinhas e boas risadas (e talvez alguns desvios).",
                "Plymouth Valiant 1973 rosa e enferrujado",
                Review(2, "Motorista simpático, mas errou o caminho 3 vezes. O carro cheira a donuts."),
                50.05
            ),
            DriverOption(
                2,
                "Dominic Toretto",
                "Ei, aqui é o Dom. Pode entrar, vou te levar com segurança e rapidez ao seu destino. Só não mexa no rádio, a playlist é sagrada.",
                "Dodge Charger R/T 1970 modificado",
                Review (4, "Que viagem incrível! O carro é um show à parte e o motorista, apesar de ter uma cara de poucos amigos, foi super gente boa. Recomendo!"),
                100.09
            ),
            DriverOption(
                3,
                "James Bond",
                "Boa noite, sou James Bond. À seu dispor para um passeio suave e discreto. Aperte o cinto e aproveite a viagem.",
                "Aston Martin DB5 clássico",
                Review(5, "Serviço impecável! O motorista é a própria definição de classe e o carro é simplesmente magnífico. Uma experiência digna de um agente secreto."),
                200.18
            ),
            DriverOption(
                4,
                "Thanos",
                "Calma que só vou eliminar metade da humanidade.",
                "HB-20 2022",
                Review(2, "Motorista simpático, mas errou o caminho 3 vezes. O carro cheira a donuts."),
                171.0
            )

        )
    }

}