package com.uce.dispositivosmoviles

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login2 : AppCompatActivity() {

    lateinit var button : Button
    lateinit var password : TextView
    lateinit var user : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        var button = findViewById<Button>(R.id.btnLogin)
        var user= findViewById<TextView>(R.id.txtUserName)
        var password = findViewById<TextView>(R.id.txtUserPassword)

        button.setOnClickListener {
            val userText = user.text.toString()
            val passText = password.text.toString()

            if(userText == "admin" && passText == "root"){
                Toast.makeText(
                    this,
                    "Redirigiendo a la siguiente pestaña...",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                    this,
                    "Usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}