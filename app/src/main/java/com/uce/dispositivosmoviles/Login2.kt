package com.uce.dispositivosmoviles

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uce.dispositivosmoviles.databinding.ActivityLogin2Binding

class Login2 : AppCompatActivity() {

    lateinit var button : Button
    lateinit var password : TextView
    lateinit var user : TextView

    lateinit var binding : ActivityLogin2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btnLogin.setOnClickListener {

            if(binding.txtUserName.text.toString() == "admin" &&
                binding.txtUserPassword.text.toString() == "root"){
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