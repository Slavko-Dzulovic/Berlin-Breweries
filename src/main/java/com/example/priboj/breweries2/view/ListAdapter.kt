package com.example.priboj.breweries2.view

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.priboj.breweries2.BreweryDetailsActivity
import com.example.priboj.breweries2.R
import com.example.priboj.breweries2.model.Brewery

class ListAdapter(val breweries: Collection<Brewery>, val context: Context): RecyclerView.Adapter<ListingItem>()
{
    override fun getItemCount(): Int
    {
        return breweries.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingItem
    {
        val view = LayoutInflater.from(context).inflate(R.layout.listing_item, parent, false);
        return  ListingItem(view);
    }

    override fun onBindViewHolder(listingItem: ListingItem, position: Int)
    {
        val brewery = breweries.elementAt(position);
        listingItem.setData(brewery);
        listingItem.breweryCard.setOnClickListener {
            val intent = Intent(context, BreweryDetailsActivity::class.java);
            context.startActivity(intent);
        }
    }
}