package com.example.priboj.breweries2

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.priboj.breweries2.model.Brewery
import com.example.priboj.breweries2.network.HTTPDataHandler
import com.example.priboj.breweries2.network.parsers.DetailsParser
import kotlinx.android.synthetic.main.listing_item.*

class BreweryDetailsActivity : AppCompatActivity()
{
    lateinit var detailImageView: ImageView;
    lateinit var detailText: TextView;
    lateinit var detailDescription: TextView;


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brewery_details)

        initUI();
        addDescription();
    }

    private fun initUI()
    {
        detailImageView = findViewById<ImageView>(R.id.image_detail);
        detailText = findViewById<TextView>(R.id.name_detail);
        detailDescription = findViewById<TextView>(R.id.description_detail);
    }

    private fun setData(brewery: Brewery)
    {
        Glide.with(this).load(brewery.imageURL).into(detailImageView);
        detailText.text = brewery.name;
        detailDescription.text = brewery.description;
    }

    private fun addDescription()
    {
        val descriptionAsyncTask = DetailsAsyncTask();
        descriptionAsyncTask.execute("http://exceptionalapps.net/androidkurs/merchant.json");
    }

    inner class DetailsAsyncTask: AsyncTask<String, Void, String>()
    {
        override fun doInBackground(vararg strings: String?): String?
        {
            var urlString = strings[0];
            urlString?.let{ return HTTPDataHandler(urlString).httpData; }

            return null;
        }

        override fun onPostExecute(result: String?)
        {
            super.onPostExecute(result);

            result?.let {
                val parser = DetailsParser();
                parser.parse(it);
                setData(parser.brewery)

            }

        }
    }
}
