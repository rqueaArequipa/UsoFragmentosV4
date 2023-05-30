package com.miempresa.usofragmentosv4

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorElementos(val ListaElementos:ArrayList<Elementos>): RecyclerView.Adapter<AdaptadorElementos.ViewHolder>() {

    override fun getItemCount(): Int {
        return ListaElementos.size;
    }
    class ViewHolder (itemView : View):RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.txt)
        val fImagen = itemView.findViewById<ImageView>(R.id.img);
        //set the onclick listener for the singlt list item
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fTexto?.text=ListaElementos[position].texto
        holder.fImagen?.setImageBitmap(ListaElementos[position].imagen)

        holder.itemView.setOnClickListener(){
            val valor: String = ListaElementos[position].texto
            val intent = Intent(holder.itemView.context, DetallesContacto::class.java)
            intent.putExtra("nombre", valor)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.elementoslista, parent, false);
        return ViewHolder(v);
    }
}
