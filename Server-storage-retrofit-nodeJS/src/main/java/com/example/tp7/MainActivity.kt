package com.example.tp7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener{
            findViewById<ProgressBar>(R.id.progressBar).isVisible=true
            val Name = findViewById<EditText>(R.id.moviename)
            val Mname =Name.text.toString()
            getActorByMovie(Mname)
        }
        findViewById<Button>(R.id.addactor).setOnClickListener{
            findViewById<ProgressBar>(R.id.progressBar).isVisible=true
            val id = findViewById<EditText>(R.id.ID).text.toString().toLongOrNull()
            val fname = findViewById<EditText>(R.id.firstname ).text.toString()
            val lname = findViewById<EditText>(R.id.lastname).text.toString()
            val gender = findViewById<EditText>(R.id.gender).text.toString()

            val act= Actor(id,fname,lname,gender)
            adduser(act)

        }
        findViewById<Button>(R.id.button2).setOnClickListener{
            findViewById<ProgressBar>(R.id.progressBar).isVisible=true
            getMovies()
        }
    }



    private fun getMovies (){
        val call = RetrofitService.endpoint.getMoveisNames()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                Toast.makeText(this@MainActivity, "une erreur serveur"+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response?.isSuccessful!!) {
                    findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                    val list = response.body()
                    for (item in list!!) {
                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                    Toast.makeText(this@MainActivity, "une erreur client", Toast.LENGTH_SHORT).show()

                }
            }
        }
        )
    }
    private fun getActorByMovie(name:String){
        val call = RetrofitService.endpoint.getactorsbymovie(name)
        call.enqueue(object : Callback<List<Actor>> {
            override fun onFailure(call: Call<List<Actor>>, t: Throwable) {
                findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                Toast.makeText(this@MainActivity, "une erreur serveur"+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Actor>>, response: Response<List<Actor>>) {
                if (response?.isSuccessful!!){
                    findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                    val list = response.body()
                    for (item in list!!) {
                        Toast.makeText(this@MainActivity, item.firstname+" "+item.lastname, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                    Toast.makeText(this@MainActivity, "une erreur client", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
    private fun adduser(user:Actor){
        val call = RetrofitService.endpoint.addactor(user)
        call.enqueue(object :Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                Toast.makeText(this@MainActivity, "une erreur serveur"+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response?.isSuccessful!!){
                    findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                    val list = response.body()
                    for (item in list!!) {
                        Toast.makeText(this@MainActivity, user.firstname+" has been added", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    findViewById<ProgressBar>(R.id.progressBar).isInvisible=true
                    Toast.makeText(this@MainActivity, "une erreur client", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}
