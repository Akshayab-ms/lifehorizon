package com.example.applifehorizon

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.textfield.TextInputEditText
import java.util.*


class MainActivity : AppCompatActivity() {

    var name: TextInputEditText? = null
    var mail: EditText? = null
    var mobileNo: TextInputEditText? = null
    var password: TextInputEditText? = null
    var confirmPassword: TextInputEditText? = null
    var button: Button? = null
    var newUser: String? = null
    var newMail: String? = null
    var newPassword: String? = null
    var newCnFrmPass: String? = null
    var newPhNo: String? = null
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.textInputEditText6)
        mail = findViewById(R.id.textInputEditText2)
        mobileNo = findViewById(R.id.textInputEditText3)
        password = findViewById(R.id.textInputEditText5)
        confirmPassword = findViewById(R.id.textInputEditText4)
        button = findViewById(R.id.button)
        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        if (!sharedPreferences?.getString("phoneKey", "")!!.isEmpty()) {
          // startActivity(Intent(this, LoginActivity::class.java))
        }
        button?.setOnClickListener(View.OnClickListener {
            newUser = Objects.requireNonNull(name?.getText()).toString()
            newMail = Objects.requireNonNull(mail?.getText()).toString()
            newPassword = Objects.requireNonNull(password?.getText()).toString()
            newCnFrmPass = Objects.requireNonNull(confirmPassword?.getText()).toString()
            newPhNo = Objects.requireNonNull(mobileNo?.getText()).toString()
            checkDataEntered()
            editor?.putString(Name, newUser)
            editor?.putString(email, newMail)
            editor?.putString(Password, newPassword)
            editor?.putString(ConfirmPassword, newCnFrmPass)
            editor?.putString(phone, newPhNo)
            val commit = editor?.commit()
        })
    }

    fun isEmail(text: TextInputEditText?): Boolean {
        val newMail: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return !TextUtils.isEmpty(newMail) && Patterns.EMAIL_ADDRESS.matcher(newMail).matches()
    }

    fun isPhone(text: TextInputEditText?):Boolean {
        var newPhNo: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return !TextUtils.isEmpty(newPhNo) && Patterns.PHONE.matcher(newPhNo).matches()

    }

    fun isEmpty(text: TextInputEditText?): Boolean {
        val str: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return TextUtils.isEmpty(str)
    }




    private fun checkDataEntered() {
        if (newUser!!.isEmpty()) {
            name!!.error = "Enter your name in the field"
        } else if (isEmpty(mail as TextInputEditText?)) {
            mail!!.error = "It should not be empty"
        } else if (!isEmail(mail as TextInputEditText?)) {
            mail!!.error = "Enter valid email"
        } else if (isEmpty(mobileNo)) {
            mobileNo!!.error = "Enter your Phone number"
        } else if (!isPhone(mobileNo)){
            mobileNo!!.error = "Enter valid number "
        }
        else if (isEmpty(password)) {
            password!!.error = "This field required password"
        } else if (isEmpty(confirmPassword)) {
            confirmPassword!!.error = "Enter your confirm password"
        } else if (confirmPassword!!.text.toString() != password!!.text.toString()) {
            confirmPassword!!.error = "Your password does not matching"
        } else {
            Toast.makeText(this@MainActivity, "Registered Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val MyPREFERENCES = "myPreferences"
        const val Name = "nameKey"
        const val email = "mailKey"
        const val phone = "phoneKey"
        const val Password = "passWordKey"
        const val ConfirmPassword = "confirmPassKey"
    }
}

