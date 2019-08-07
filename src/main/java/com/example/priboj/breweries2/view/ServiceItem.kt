package com.example.priboj.breweries2.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.priboj.breweries2.R
import com.example.priboj.breweries2.model.Service

class ServiceItem : RecyclerView.ViewHolder
{
    private var serviceText: TextView

    constructor(view: View) : super(view)
    {
        serviceText = view.findViewById(R.id.service_text)
    }

    fun setData(service: Service)
    {
        serviceText.text = service.name
    }
}
