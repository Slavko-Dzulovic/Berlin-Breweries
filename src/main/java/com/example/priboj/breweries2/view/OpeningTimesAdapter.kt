package com.example.priboj.breweries2.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.priboj.breweries2.R
import com.example.priboj.breweries2.model.OpeningTime
import com.example.priboj.breweries2.model.Service

class OpeningTimesAdapter(val openingTimes : Collection<OpeningTime>, val context: Context): RecyclerView.Adapter<OpeningTimeItem>()
{
    override fun getItemCount(): Int
    {
        return openingTimes.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpeningTimeItem
    {
        val view = LayoutInflater.from(context).inflate(R.layout.services, parent, false);
        return OpeningTimeItem(view);
    }

    override fun onBindViewHolder(holder: OpeningTimeItem, position: Int)
    {
        val openingTime = openingTimes.elementAt(position);
        holder.setData(openingTime);
    }
}