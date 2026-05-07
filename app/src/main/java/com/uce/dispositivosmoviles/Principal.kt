package com.uce.dispositivosmoviles

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.uce.dispositivosmoviles.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {
    lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initVariables()

    }

    private fun initVariables() {
        intent.extras.let {
            var saludo = it?.getString("xx1")
            Snackbar.make(binding.urlTxt,
                saludo.toString(),
                Snackbar.LENGTH_LONG).show()
        }
    }

    private fun initListeners() {
        binding.urlBtn.setOnClickListener{
            val url = binding.urlTxt.text.toString()

            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }
    }
}