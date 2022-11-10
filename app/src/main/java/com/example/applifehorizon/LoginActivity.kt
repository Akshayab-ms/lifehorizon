package com.example.applifehorizon


import android.os.Bundle

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences


import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.applifehorizon.MainActivity.Companion.MyPREFERENCES
import com.example.applifehorizon.MainActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class LoginActivity: androidx.appcompat.app.AppCompatActivity() {
    var MobileNumber: EditText? = null
    var passWord: EditText? = null
    var button: Button? = null
    var buttonregister:Button?=null
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE)
        MobileNumber = findViewById(R.id.mobile)
        passWord = findViewById(R.id.password)
        buttonregister=findViewById(R.id.btn_reg)
        button = findViewById(R.id.button2)
        button?.setOnClickListener(View.OnClickListener { checkLoginDetails() })

        buttonregister?.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }


    fun isEmpty(text: TextInputEditText?): Boolean {
        val str: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return TextUtils.isEmpty(str)
    }

    private fun checkLoginDetails() {
        val mobileNo = MobileNumber!!.text.toString()
        val password = passWord!!.text.toString()
        val sharedPhone = sharedPreferences!!.getString("phoneKey", "")
        val sharedPassword = sharedPreferences!!.getString("passWordKey", "")
        if (isEmpty(MobileNumber as TextInputEditText?)) {
            MobileNumber!!.error = "Enter your Phone number to login!"
        } else if (isEmpty(passWord as TextInputEditText?)) {
            passWord!!.error = "This field required password"
        } else if (mobileNo == sharedPhone && password == sharedPassword) {
            Toast.makeText(this@LoginActivity, "Login Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LoginActivity, LifeActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(
                this@LoginActivity,
                "MobileNumber and Password Does not match",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}