package com.example.applifehorizon

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class TempActivity : AppCompatActivity() {


    var etCity: TextView? = null

    var tvResult: TextView? = null
    var btn: Button? = null
    var btngetin: Button? = null
    var tv_link:TextView?=null
    lateinit var city1:String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        etCity = findViewById(R.id.et_loc)
        tvResult = findViewById(R.id.tv_scroll)
        btn = findViewById(R.id.get_btn)
        tv_link=findViewById(R.id.tab)
        btngetin=findViewById(R.id.btnlink)


        val bundle: Bundle? = intent.extras
        city1 = bundle?.get("cityname") as String
        Log.d("hjj", "hh" + city1)
        Log.d("MainActivity", "onCreate() method finished" + "  " + city1)


        // var city2= bundle?.get("txtinTwo") as String
        // var city3 = bundle?.get("txtinThree") as String


        etCity?.setText(city1 +" ")











        btn?.setOnClickListener {
            getWeatherDetails()

        }


        btngetin?.setOnClickListener{


            loodetails()
        }



    }
    fun loodetails(){


        if(etCity?.text?.toString()?.trim()?.equals("Bangalore")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Bangalore"))
            startActivity(i)
        }
        else if(etCity?.text?.toString()?.trim()?.equals("Mysore")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Mysore"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("Chennai")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Chennai"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("Mumbai")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Mumbai"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("Hyderabad")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/hyderabad"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("pune")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/pune"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("Belgaum")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Belgaum"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("Coimbatore")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Coimbatore"))
            startActivity(i)

        }
        else if(etCity?.text?.toString()?.trim()?.equals("Kerala")!!){
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/kerala"))
            startActivity(i)

        }

    }


    fun getWeatherDetails() {



        val url =
            "https://api.openweathermap.org/data/2.5/weather?q=$city1&appid=0d6c51cd2b5959387bf840e166bc5776"
        val appid = "0d6c51cd2b5959387bf840e166bc5776"
        val queue = Volley.newRequestQueue(applicationContext)
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val `object` = response.getJSONObject("main")
                    val object1 = response.getJSONObject("coord")
                    val lone = object1.getString("lon")
                    val lane = object1.getString("lat")
                    val temperature = `object`.getString("temp")
                    tvResult!!.append("country:$city1,Temperature:$temperature,longitude:$lone,latitude$lane\n\n")
                } catch (e: JSONException) {
                    Toast.makeText(applicationContext, "erro", Toast.LENGTH_LONG).show()
                }
            }
        ) { Toast.makeText(applicationContext, "eehh", Toast.LENGTH_LONG).show() }
        queue.add(request)
    }
}