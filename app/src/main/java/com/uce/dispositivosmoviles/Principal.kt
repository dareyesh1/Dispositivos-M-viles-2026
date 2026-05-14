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
import com.google.android.material.snackbar.Snackbar
import com.uce.dispositivosmoviles.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity(), AdapterView.OnItemClickListener,
AdapterView.OnItemSelectedListener{

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initVariables()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    private fun initVariables() {
        intent.extras?.let {
            val saludo = it.getString("xx1")

            Snackbar.make(
                binding.urlTxt,
                saludo ?: "Bienvenido",
                Snackbar.LENGTH_LONG
            ).show()

            var options = listOf<String>("Youtube", "Google",
                "Fcebook", "Apple")
            var adapter = ArrayAdapter(this, R.layout.my_spinner_layout,
                options)

            binding.androidSpinner.adapter = adapter
        }
    }

    private fun initListeners() {

        binding.urlBtn.setOnClickListener {

            var url = binding.urlTxt.text.toString().trim()

            // Agrega https:// si el usuario no lo escribió
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        binding.logoutBtn.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Está usted seguro de salir de la aplicación?")
                .setCancelable(true)

                .setPositiveButton("Sí") { _, _ ->
                    val intent = Intent(this, Login2::class.java)
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

    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        Toast.makeText(this, "Posicion seleccionada es ${position}",
            Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(
        p0: AdapterView<*>?,
        p1: View?,
        p2: Int,
        p3: Long
    ) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}