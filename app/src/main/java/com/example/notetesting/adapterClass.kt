package com.example.notetesting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notetesting.Model.ReadDataModel

class adapterClass() : RecyclerView.Adapter<adapterClass.viewholder>() {

    lateinit var list: List<ReadDataModel>
    lateinit var context: Context


    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name:TextView=itemView.findViewById(R.id.name)
        val home:TextView=itemView.findViewById(R.id.hom)
        val dept:TextView=itemView.findViewById(R.id.dep)
        val project:TextView=itemView.findViewById(R.id.proj)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view:View

        view=LayoutInflater.from(parent.context).inflate(R.layout.itemscard,parent,false);


        return viewholder(view)

    }

    override fun getItemCount(): Int {

     return list.size

    }

    fun setData(data: List<ReadDataModel>) {

        this.list = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
      val  model=list.get(position)

        holder.name.text=model.name
        holder.home.text=model.home
        holder.dept.text=model.dep
        holder.project.text=model.proj



    }


}