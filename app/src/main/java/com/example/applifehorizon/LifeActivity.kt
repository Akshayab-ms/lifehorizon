package com.example.applifehorizon

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class LifeActivity: AppCompatActivity() {
    lateinit var climate: Spinner
    lateinit var job: Spinner
    lateinit var night: Spinner
    lateinit var med: Spinner
    lateinit var cost: Spinner
    lateinit var apply: Button
    var a: Int = 0
    var b: Int = 0
    var c: Int = 0
    var d: Int = 0
    var e: Int = 0
    var sum: Int = 0
    var avg: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life)
        climate = findViewById(R.id.sp_climate) as Spinner
        cost = findViewById(R.id.sp_cost) as Spinner
        med = findViewById(R.id.sp_med) as Spinner
        night = findViewById(R.id.sp_night) as Spinner
        job = findViewById(R.id.sp_job) as Spinner
        apply = findViewById(R.id.button) as Button
        //result=findViewById(R.id.tv_result) as TextView
        val options = arrayOf("1", "2", "3", "4", "5")
        climate.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        climate.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                a = options.get(position).toInt()


            }

        }
        med.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        med.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                b = options.get(position).toInt()

            }

        }
        night.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        night.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                c = options.get(position).toInt()
            }

        }
        job.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        job.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                //result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                d = options.get(position).toInt()
            }

        }
        cost.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        cost.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                e = options.get(position).toInt()
            }

        }
        apply.setOnClickListener {
            calc()
            intent = Intent(this, CityActivity::class.java)
            intent.putExtra("id_value", avg)
            startActivity(intent)
        }


    }




    fun calc() {

        val list = listOf(a, b, c, d, e)
        avg = list.average().toInt()
        //Log.d("MainActivity","onCreate() method finished"+"  "+avg)
        /* if(avg>=2) {


            Log.d("one", "helo" + print("chennai"))
            Log.d("one", "helo" + print("bamg"))
            Log.d("one", "helo" + print("cmbt"))
        }
        else if(avg>=4){
            Log.d("on", "helo" + print("chennai"))
            Log.d("oe", "helo" + print("bamg"))
            Log.d("ne", "helo" + print("cmbt"))

        }
        else{
            Log.d("o", "helo" + print("chennai"))
            Log.d("ne", "helo" + print("bamg"))
            Log.d("ne", "helo" + print("cmbt"))
        }



    }*/
    }
}
