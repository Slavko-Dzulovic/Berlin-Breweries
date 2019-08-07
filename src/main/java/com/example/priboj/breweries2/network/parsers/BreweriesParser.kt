package com.example.priboj.breweries2.network.parsers

import com.example.priboj.breweries2.model.Address
import com.example.priboj.breweries2.model.Brewery
import org.json.JSONException
import org.json.JSONObject

class BreweriesParser
{
    lateinit var breweries: ArrayList<Brewery>

    fun parse(json: String)
    {
        breweries=ArrayList<Brewery>()

        try
        {
            val jsonObject = JSONObject(json);
            val jsonArray = jsonObject.getJSONArray("breweries");

            for(i in 0 until jsonArray.length())
            {
                val jsonBrewery = jsonArray[i] as JSONObject;
                val id = jsonBrewery.getLong("id");
                val name = jsonBrewery.getString("name");
                val imageURL = jsonBrewery.getString("imageURL");

                val addressJSONObject = jsonBrewery.getJSONObject("address");

                val street = addressJSONObject.getString("street");
                val number = addressJSONObject.getString("number");
                val zipCode = addressJSONObject.getString("zipcode");
                val city = addressJSONObject.getString("city");

                val brewery = Brewery(id, name, Address(street, number, zipCode, city), imageURL);
                breweries.add(brewery);
            }

        } catch(e: JSONException)
        {
            println(e);
        }
    }
}