package com.example.movieexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter(this,loadData())


    }


    fun loadData():List<Movie> {
        val data = mutableListOf<Movie>()
        data.add(Movie("Movie 1",2001))
        data.add(Movie("Movie 2",2002))
        data.add(Movie("Movie 3",2003))
        data.add(Movie("Movie 4",2004))
        data.add(Movie("Movie 5",2005))
        data.add(Movie("Movie 6",2006))
        data.add(Movie("Movie 7",2007))
        data.add(Movie("Movie 8",2008))
        data.add(Movie("Movie 9",2009))
        data.add(Movie("Movie 10",2010))
        data.add(Movie("Movie 11",2011))
        data.add(Movie("Movie 12",2012))
        data.add(Movie("Movie 13",2013))
        data.add(Movie("Movie 14",2014))
        data.add(Movie("Movie 15",2015))
        data.add(Movie("Movie 16",2016))
        data.add(Movie("Movie 17",2017))
        data.add(Movie("Movie 18",2018))
        return data
    }

}
