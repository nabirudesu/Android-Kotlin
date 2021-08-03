package com.example.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var i:Long=0
        findViewById<Button>(R.id.button).setOnClickListener{
            i++
            val Name = findViewById<EditText>(R.id.name)
            val Year = findViewById<EditText>(R.id.year)
            val Language = findViewById<EditText>(R.id.language)
            val Mname =Name.text.toString()
            val Myear=Year.text.toString()
            val Mlang=Language.text.toString()
            var movie = Movie(Mname,Myear,Mlang)
            RoomService.appDatabase.getMovieDao().addMovie(movie)
            if (RoomService.appDatabase.getMovieDao().getMovies() != null)
                Toast.makeText(this,"insertion effectuée avec succès", Toast.LENGTH_SHORT).show()

        }
    }
}