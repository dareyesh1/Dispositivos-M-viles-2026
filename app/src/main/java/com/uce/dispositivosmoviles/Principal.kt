package com.uce.dispositivosmoviles

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.uce.dispositivosmoviles.adapters.CustomAdapter
import com.uce.dispositivosmoviles.databinding.ActivityPrincipalBinding
import com.uce.dispositivosmoviles.dto.Empresas

class Principal : AppCompatActivity(),
    AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initVariables()
    }

    private fun initVariables() {

        // Mensaje recibido desde otra Activity
        val saludo = intent.extras?.getString("xx1")

        Snackbar.make(
            binding.urlTxt,
            saludo ?: "Bienvenido",
            Snackbar.LENGTH_LONG
        ).show()

        // OPCIONES DEL SPINNER
        val options = listOf(
            "Youtube",
            "Google",
            "Facebook",
            "Apple"
        )

        val adapter = ArrayAdapter(
            this,
            R.layout.my_spinner_layout,
            options
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.androidSpinner.adapter = adapter
        binding.androidSpinner.onItemSelectedListener = this

        // DATOS DEL RECYCLERVIEW
        val optionsEmpresas = listOf(
            Empresas(
                "Youtube",
                "https://images.seeklogo.com/logo-png/27/1/youtube-icon-logo-png_seeklogo-270054.png"
            ),
            Empresas(
                "Facebook",
                "https://marketplace.canva.com/KrzKM/MAGzNqKrzKM/1/tl/canva-facebook-logo-MAGzNqKrzKM.png"
            )
        )

        val adapterRecycleView = CustomAdapter(optionsEmpresas)

        binding.RvUrls.adapter = adapterRecycleView

        binding.RvUrls.layoutManager = GridLayoutManager(
            this,
            2
        )
    }

    private fun initListeners() {

        // BOTÓN PARA ABRIR URL
        binding.urlBtn.setOnClickListener {

            var url = binding.urlTxt.text.toString().trim()

            if (url.isEmpty()) {

                Toast.makeText(
                    this,
                    "Ingrese una URL",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Agrega https:// si no existe
            if (!url.startsWith("http://") &&
                !url.startsWith("https://")
            ) {
                url = "https://$url"
            }

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )

            startActivity(intent)
        }

        // BOTÓN CERRAR SESIÓN
        binding.logoutBtn.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Está usted seguro de salir de la aplicación?")
                .setCancelable(true)

                .setPositiveButton("Sí") { _, _ ->

                    val intent = Intent(
                        this,
                        Login2::class.java
                    )

                    startActivity(intent)
                    finish()
                }

                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }

                .setNeutralButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }

                .show()
        }
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {

        val item = parent?.getItemAtPosition(position).toString()

        Toast.makeText(
            this,
            "Seleccionaste $item",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // No hacer nada
    }
}