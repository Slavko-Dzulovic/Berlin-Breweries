package com.example.priboj.breweries2.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.priboj.breweries2.R
import com.example.priboj.breweries2.model.Brewery
import com.example.priboj.breweries2.model.Service

class ServiceAdapter(val services: Collection<Service>, val context: Context): RecyclerView.Adapter<ServiceItem>()
{
    override fun getItemCount(): Int
    {
        return services.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceItem
    {
        val view = LayoutInflater.from(context).inflate(R.layout.services, parent, false);
        return ServiceItem(view);
    }

    override fun onBindViewHolder(holder: ServiceItem, position: Int)
    {
        val service = services.elementAt(position);
        holder.setData(service);
    }
}