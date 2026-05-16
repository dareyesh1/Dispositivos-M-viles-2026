package com.uce.dispositivosmoviles.adapters

import android.media.RouteListingPreference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.uce.dispositivosmoviles.R
import com.uce.dispositivosmoviles.databinding.MySpinnerLayoutBinding
import com.uce.dispositivosmoviles.dto.Empresas

class CustomAdapter(var lista: List<Empresas>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return CustomViewHolder(inflater
            .inflate(R.layout.my_spinner_layout,
                parent,
                false)
        )
    }


    override fun onBindViewHolder(
        holder: CustomViewHolder,
        position: Int
    ) {
        holder.render(lista[position])
    }


    override fun getItemCount() = lista.size



    class CustomViewHolder(view:View): RecyclerView.ViewHolder(view){

        private var localBinding : MySpinnerLayoutBinding = MySpinnerLayoutBinding.bind(view)
         fun render(item: Empresas){
            localBinding.txtEmpresa.setText(item.name)
             Picasso.get().load(item.image).into(localBinding.imgEmpresa)
        }
    }
}


