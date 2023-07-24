package com.example.planets.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.planets.Adapter.PlanetAdapter.*
import com.example.planets.Models.PlanetData
import com.example.planets.PlanetInfoActivity
import com.example.planets.R

class PlanetAdapter(var planets: List<PlanetData>) : RecyclerView.Adapter<PlanetViewHolder>() {

    class PlanetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.title)
        var planetImg = view.findViewById<ImageView>(R.id.planet_img)
        var galaxy = view.findViewById<TextView>(R.id.galaxy)
        var distance = view.findViewById<TextView>(R.id.distance)
        var gravity = view.findViewById<TextView>(R.id.gravity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return PlanetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetInfoActivity::class.java)
            intent.putExtra("planet", planets[position])
            intent.putExtra("planetImg", dummyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planets[position].title
        holder.galaxy.text = planets[position].galaxy
        holder.distance.text = planets[position].distance + " m km"
        holder.gravity.text = planets[position].gravity + " m/ss"

        when (planets[position].title!!.lowercase()) {
            "mars" -> dummyImage = R.drawable.ic_mars
            "earth" -> dummyImage = R.drawable.ic_earth
            "sun" -> dummyImage = R.drawable.ic_sun
            "jupiter" -> dummyImage = R.drawable.ic_jupiter
            "mercury" -> dummyImage = R.drawable.ic_mercury
            "moon" -> dummyImage = R.drawable.ic_moon
            "neptune" -> dummyImage = R.drawable.ic_neptune
            "saturn" -> dummyImage = R.drawable.ic_saturn
            "uranus" -> dummyImage = R.drawable.ic_uranus
            "venus" -> dummyImage = R.drawable.ic_venus
        }
        holder.planetImg.setImageResource(dummyImage!!)
    }

    override fun getItemCount(): Int {
        return planets.size
    }


}