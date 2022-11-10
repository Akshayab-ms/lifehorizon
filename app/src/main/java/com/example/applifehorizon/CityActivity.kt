package com.example.applifehorizon


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class CityActivity : AppCompatActivity() {

    var txtinOne=""
    var txtinTwo=""
    var txtinThree=""

    lateinit var cityone:TextView

    lateinit var citytwo:TextView

    lateinit var cityThree:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)


        cityone=findViewById(R.id.tv_firstp)

        citytwo=findViewById(R.id.tv_secondp)

        cityThree=findViewById(R.id.tv_thirdp)




        city()

        cityone.setOnClickListener {
            txtinOne= cityone.text as String

            if(txtinOne=="Bangalore"){



                /*val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinOne)
                startActivity(intent)

            }
            else if(txtinOne=="Kerala"){
                /* val url = "https://www.javatpoint.com/kotlin-android-textview-and-edittext"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinOne)
                startActivity(intent)
            }
            else if(txtinOne=="Mysore"){
                /* val url = "https://www.javatpoint.com/kotlin-android-textview-and-edittext"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinOne)
                startActivity(intent)

            }
            else{
                Toast.makeText(
                    this@CityActivity,
                    "Does not match",
                    Toast.LENGTH_SHORT
                ).show()
            }



        }
        citytwo.setOnClickListener{

            txtinTwo=citytwo.text as String



            if(txtinTwo=="Chennai"){
                /*  val url = "http://www.google.com"
                  intent = Intent(Intent.ACTION_VIEW)
                  intent.data = Uri.parse(url)
                  startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinTwo)
                startActivity(intent)

            }
            else if(txtinTwo=="Hyderabad"){
                /*  val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinTwo)
                startActivity(intent)
            }
            else if(txtinTwo=="Pune"){
                /*  val url = "http://www.google.com"
              intent = Intent(Intent.ACTION_VIEW)
              intent.data = Uri.parse(url)
              startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinTwo)
                startActivity(intent)

            }
            else{
                Toast.makeText(
                    this@CityActivity,
                    "Does not match",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        cityThree.setOnClickListener {
            txtinThree=cityThree.text as String
            if(txtinThree=="Mumbai"){
                /*  val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinThree)
                startActivity(intent)
            }
            else if(txtinThree=="Coimbatore"){
                /*  val url = "http://www.google.com"
               intent = Intent(Intent.ACTION_VIEW)
               intent.data = Uri.parse(url)
               startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinThree)
                startActivity(intent)
            }
            else if(txtinThree=="Belgaum"){
                /*  val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinThree)
                startActivity(intent)

            }
            else{
                Toast.makeText(
                    this@CityActivity,
                    "Does not match",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }




    }
    fun city(){
        val bundle: Bundle? = intent.extras
        var id = bundle?.get("id_value") as Int
        Log.d("hjj","hh"+id)
        Log.d("MainActivity","onCreate() method finished"+"  "+id)
        if(id>3) {

            cityone.setText("Bangalore").toString()
            citytwo.setText("Chennai").toString()
            cityThree.setText("Mumbai").toString()


/*
            Log.d("one", "helo" + print("chennai"))
            Log.d("one", "helo" + print("bamg"))
            Log.d("one", "helo" + print("cmbt"))*/
        }
        else if(id==3){
            cityone.setText("Kerala").toString()
            citytwo.setText("Hyderabad").toString()
            cityThree.setText("Coimbatore").toString()
            /*Log.d("on", "helo" + print("chennai"))
            Log.d("oe", "helo" + print("bamg"))
            Log.d("ne", "helo" + print("cmbt"))
*/
        }
        else {
            cityone.setText("Mysore").toString()
            citytwo.setText("Pune").toString()
            cityThree.setText("Belgaum").toString()
            /*  Log.d("o", "helo" + print("chennai"))
              Log.d("ne", "helo" + print("bamg"))
              Log.d("ne", "helo" + print("cmbt"))*/
        }






    }
}