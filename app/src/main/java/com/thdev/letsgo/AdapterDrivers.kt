package com.thdev.letsgo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thdev.letsgo.data.DriverOption

class AdapterDrivers(
    private val myMockList: ArrayList<DriverOption>

) : RecyclerView.Adapter<AdapterDrivers.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.drivers_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = myMockList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val driver = myMockList[position]
        holder.driverName.text = driver.name
        holder.driverDescription.text = driver.description
        holder.driverVehicle.text = driver.vehicle
        holder.driverRating.text = driver.review.rating.toString() // Formatando para exibir como string
        holder.driverValue.text = driver.value.toString() // Formatando para exibir como string('.', ',')}" // Formatando para exibir como string
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val driverName: TextView = itemView.findViewById(R.id.driverName)
        val driverDescription: TextView = itemView.findViewById(R.id.driverDescription)
        val driverVehicle: TextView = itemView.findViewById(R.id.driverVehicle)
        val driverRating: TextView = itemView.findViewById(R.id.driverRating)
        val driverValue: TextView = itemView.findViewById(R.id.driverValue)
    }

    //TODO: ONCLICK para o histórico de viagens
}