package com.jgdeveloppement.jg_road.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jgdeveloppement.jg_road.R
import com.jgdeveloppement.jg_road.models.Delivery

class DeliveryAdapter(private val context: MainActivity,
                      private val deliveryList: List<Delivery>)
    : RecyclerView.Adapter<DeliveryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.delivery_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentDelivery = deliveryList[position]

        holder.itemId.text = currentDelivery.id.toString()
        holder.service.text = currentDelivery.service
        holder.customerName.text = currentDelivery.name
        holder.customerAddress.text = currentDelivery.address
        holder.customerTown.text = context.getString(R.string.town, currentDelivery.postCode, currentDelivery.town)
    }

    override fun getItemCount(): Int = deliveryList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemId : TextView = view.findViewById(R.id.item_id)
        val service : TextView = view.findViewById(R.id.service)
        val customerName : TextView = view.findViewById(R.id.customer_name)
        val customerAddress : TextView = view.findViewById(R.id.customer_address)
        val customerTown : TextView = view.findViewById(R.id.customer_town)
    }
}