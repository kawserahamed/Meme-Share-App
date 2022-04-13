package org.primeit.memeshare

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.primeit.memeshare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    private fun loadMeme() {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val url = response.getString("url")

                Glide.with(this).load(url).into(binding.imMeme)
            },
            {

                Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show()
            })

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)

    }

    fun share(view: View) {


    }

    fun next(view: View) {


    }
}