package com.thdev.letsgo

import History
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thdev.letsgo.AdapterDrivers.ViewHolder

class AdapterHistory(
    private val myMockHistory: ArrayList<History>

) : RecyclerView.Adapter<AdapterHistory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.history_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = myMockHistory.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val history = myMockHistory[position]
        holder.dateAndTime.text = history.rides.date.toString()
        holder.driverName.text = history.rides.driver.name
        holder.origin.text = history.rides.origin
        holder.destiny.text = history.rides.destination
        holder.distance.text = history.rides.distance.toString()
        holder.travelTime.text = history.rides.duration
        holder.travelValue.text = history.rides.value.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateAndTime: TextView = itemView.findViewById(R.id.dateAndTime)
        val driverName: TextView = itemView.findViewById(R.id.driverName)
        val origin: TextView = itemView.findViewById(R.id.from)
        val destiny: TextView = itemView.findViewById(R.id.to)
        val distance: TextView = itemView.findViewById(R.id.distance)
        val travelTime: TextView = itemView.findViewById(R.id.travelTime)
        val travelValue: TextView = itemView.findViewById(R.id.travelValue)
    }

}