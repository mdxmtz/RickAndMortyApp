package com.example.miprimeraplicacion.recycler.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.NavigationStateData
import com.example.miprimeraplicacion.recycler.data.CharacterItem
import com.example.miprimeraplicacion.recycler.data.ItemSelectedValue

import com.example.miprimeraplicacion.utils.extension_fun.showToast

class MyAdapter(private val dataList:List<CharacterItem>) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userItem=dataList[position]

        with(userItem){
            val fullAddress = "${address.name} "
            holder.tvName.text=name

            holder.tvAddress.text=fullAddress
            //holder.btnDetail.text="Detalles"

            holder.tvType.text=userItem.type

            val contexto = holder.itemView.context

            holder.btnDetail.setOnClickListener {
                //contexto.showToast("Click en ${name} , edad 18", )
                Navigation.findNavController(holder.itemView).navigate(R.id.action_recycleFragment_to_characterFragment)
                NavigationStateData.setCharacterSelected(userItem)
            }

            holder.btnSheet.setOnClickListener {
                ItemSelectedValue.selectUser(userItem)

                //findNavController().navigate(R.id.action_loginFragment_to_recycleFragment)
                Navigation.findNavController(holder.itemView).navigate(R.id.action_recycleFragment_to_bottomSheetFragment)


            }


            try {
                Glide.with(contexto).load(imageURLValue).into(holder.ivUserProfile)
            }catch (e: Exception ){
                Log.w("Royal","URL: "+imageURLValue+", Message: "+e.message)

            }

        }



    }


}