package com.uce.dispositivosmoviles

import android.content.Intent
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
    var counter : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
        initListeners()
    }

    //Datos que se generan en la sesion y tienen que ser destruidos cuando se
    //cierre la sesion

    //Si no se llena de carga innecesaria el procesador
    override fun onDestroy() {
        super.onDestroy()
    }

    //No vuelve al onCreate(), porque no vuelve a crear una actividad
    override fun onStart() {
        super.onStart()
    }

    //Permite al usuario regresar a la actividad
    override fun onResume() {
        super.onResume()
    }
    fun initVariables(){
        counter = 1
    }

    fun initListeners(){
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLogin.setOnClickListener {

            if(binding.txtUserName.text.toString() == "admin" &&
                binding.txtUserPassword.text.toString() == "root"){

                //Pasar a la otra actividad (Principal)
                var intent =  Intent(this, Principal::class.java)
                startActivity(intent)

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