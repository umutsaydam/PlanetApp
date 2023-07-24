package com.example.planets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.planets.Adapter.PlanetAdapter
import com.example.planets.Objects.setPlanetData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val planetRecycler = findViewById<RecyclerView>(R.id.recyclerPlanets)
        planetRecycler.adapter = PlanetAdapter(setPlanetData.SetPlanets())
    }
}