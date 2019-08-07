package com.example.priboj.breweries2.network.parsers

import com.example.priboj.breweries2.model.*
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat

class DetailsParser
{
    lateinit var brewery: Brewery;

    fun parse(json: String)
    {
        try
        {
            val jsonBrewery= JSONObject(json);

            val id = jsonBrewery.getLong("id");
            val name = jsonBrewery.getString("name");

            val addressJSONObject = jsonBrewery.getJSONObject("address");
            val street = addressJSONObject.getString("street");
            val number =  addressJSONObject.getString("number");
            val zipcode = addressJSONObject.getString("zipcode");
            val city = addressJSONObject.getString("city");

            val description = jsonBrewery.getString("description");

            val imageURL = jsonBrewery.getString("image");

            val restaurantOpeningTimes = jsonBrewery.getJSONArray("restaurantOpeningTimes");

            val arrayROT = ArrayList<OpeningTime>()

            for(i in 0 until restaurantOpeningTimes.length())
            {
                val day1 = restaurantOpeningTimes.getJSONObject(i).getInt("day");
                val open1 = restaurantOpeningTimes.getJSONObject(i).getString("open");
                val close1 = restaurantOpeningTimes.getJSONObject(i).getString("close");

                arrayROT.add(OpeningTime(day1, open1, close1));
            }

            val latLong = jsonBrewery.getJSONObject("latLong");

            val lat = latLong.getDouble("latitude");
            val long = latLong.getDouble("longitude");

            val serviceJSONObject = jsonBrewery.getJSONArray("services");

            val arrayService = ArrayList<Service>();

            for(i in 0 until serviceJSONObject.length())
            {
                val name1 = serviceJSONObject.getJSONObject(i).getString("name");
                arrayService.add(Service(name1));
            }

            val reviewJSONObject = jsonBrewery.getJSONArray("reviews");
            val arrayReviews = ArrayList<Review>();

            val customerArrayList = ArrayList<Customer>();

            for(i in 0 until reviewJSONObject.length())
            {
                val customer = Customer(reviewJSONObject.getJSONObject(i).getJSONObject("customer").getLong("id"),
                    reviewJSONObject.getJSONObject(i).getJSONObject("customer").getString("lastName"),
                    reviewJSONObject.getJSONObject(i).getJSONObject("customer").getString("firstName"));

                customerArrayList.add(customer);
            }

            for(i in 0 until reviewJSONObject.length())
            {
                val rating = reviewJSONObject.getJSONObject(i).getInt("rating");
                val description = reviewJSONObject.getJSONObject(i).getString("description");

                val dateString = reviewJSONObject.getJSONObject(i).getString("date");
                val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString);

                val reviewName = reviewJSONObject.getJSONObject(i).getString("reviewName");

                arrayReviews.add(Review(rating, description, customerArrayList.get(i), date, reviewName));
            }

            brewery = Brewery(id,
                name,
                Address(street, number, zipcode, city),
                imageURL,
                description,
                arrayROT,
                Position(lat, long),
                arrayService,
                arrayReviews
            )

        } catch(e: JSONException)
        {
            println(e);
        }
    }
}