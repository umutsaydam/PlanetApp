package com.example.planets

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.planets.Models.PlanetData

class PlanetInfoActivity : AppCompatActivity() {
    private lateinit var obj: PlanetData
    private var planetImgExtra: Int? = null
    private lateinit var planetImg: ImageView
    private lateinit var planetTitle: TextView
    private lateinit var planetGalaxy: TextView
    private lateinit var planetDistance: TextView
    private lateinit var planetGravity: TextView
    private lateinit var planetInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_info)

        obj = intent.getParcelableExtra("planet")!!

        planetImgExtra = intent.getIntExtra("planetImg", -1)

        planetImg = findViewById(R.id.planetImg)
        planetTitle = findViewById(R.id.planetTitle)
        planetGalaxy = findViewById(R.id.planetGalaxy)
        planetDistance = findViewById(R.id.distance)
        planetGravity = findViewById(R.id.gravity)
        planetInfo = findViewById(R.id.planetInfo)



        setData(obj, planetImgExtra!!)
    }

    private fun setData(obj: PlanetData, planetImgExtra: Int) {
        planetImg.setImageResource(planetImgExtra)
        planetTitle.text = obj.title
        planetGalaxy.text = obj.galaxy
        planetDistance.text = "${obj.distance} m km"
        planetGravity.text = "${obj.gravity} m/ss"
        planetInfo.text = obj.overView
    }
}