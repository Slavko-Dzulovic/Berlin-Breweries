package com.example.priboj.breweries2.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.priboj.breweries2.R
import com.example.priboj.breweries2.model.OpeningTime
import com.example.priboj.breweries2.model.Service

class OpeningTimeItem: RecyclerView.ViewHolder
{
    private var openingTimeItemDay: TextView
    private var openingTimeItemHours: TextView

    constructor(view: View) : super(view)
    {
        openingTimeItemDay = view.findViewById(R.id.day)
        openingTimeItemHours = view.findViewById(R.id.hours)
    }

    fun setData(openingTime: OpeningTime)
    {
        openingTimeItemDay.text = openingTime.day.toString()
        openingTimeItemHours.text = openingTime.open+openingTime.close
    }
}
