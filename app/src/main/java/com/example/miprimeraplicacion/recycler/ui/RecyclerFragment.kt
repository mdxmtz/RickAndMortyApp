package com.example.miprimeraplicacion.recycler.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miprimeraplicacion.data.NavigationStateData
import com.example.miprimeraplicacion.data.retrofit.RetrofitConnection
import com.example.miprimeraplicacion.data.retrofit.entity.get_character.GetCharacterResponse
import com.example.miprimeraplicacion.data.retrofit.entity.get_character.Info
import com.example.miprimeraplicacion.data.retrofit.entity.get_character.Result
import com.example.miprimeraplicacion.databinding.FragmentRecycleBinding
import com.example.miprimeraplicacion.recycler.adapter.MyAdapter
import com.example.miprimeraplicacion.recycler.data.ItemSelectedValue
import com.example.miprimeraplicacion.recycler.enums.SetData
import com.example.miprimeraplicacion.utils.extension_fun.showToast
import com.example.miprimeraplicacion.utils.extension_fun.toUserItemList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.typeOf


class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecycleBinding?=null
    private val binding get() = _binding!!


    private val getDataSource = SetData.Retrofit




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recycle, container, false)
        Log.i("CicloVida","onCreateView")

        _binding= FragmentRecycleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("CicloVida","onViewCreated")

        getFromRetrofit()

        setUpListeners()

        setUpViews()

    }

    private fun setUpViews() {


        val prevUrl =NavigationStateData.getUrlPrev()

        if(prevUrl==null){
            binding.btnPrev.isEnabled=false
        }else{
            binding.btnPrev.isEnabled=NavigationStateData.getUrlPrev().isNotEmpty()
        }

        //showToast("Prev: ${NavigationStateData.getUrlPrev()} NotEmpty: ${NavigationStateData.getUrlPrev().isNotEmpty()}")

/*
        if(NavigationStateData.getUrlNext().isEmpty()){
            fNext=false
        }else
            fNext=true
        */
        binding.btnNext.isEnabled=NavigationStateData.getUrlNext().isNotEmpty()
        //showToast("Next: ${NavigationStateData.getUrlNext()}, NotEmpty: ${NavigationStateData.getUrlNext().isNotEmpty()}")


    }

    private fun setUpListeners() {
        binding.btnNext.setOnClickListener {
            val url=NavigationStateData.getUrlNext()
            //showToast("Click en Boton Next: ${url}")
            getFromRetrofitDirect(url)
        }
        binding.btnPrev.setOnClickListener {

            val url=NavigationStateData.getUrlPrev()
            Log.i("Debug","${url}")
            //showToast("Click en boton previo ${url}")
            Log.i("Debug","Expresion: ${url==null || url.isEmpty()}")
            if(url==null || url.isEmpty())
                showToast("ERROR: Url es nulo")
            else
                getFromRetrofitDirect(url)

        }

    }

    private fun getFromRetrofitDirect(url:String){
        Log.i("Debug","Llamada Retrofit directo ${url}")
        if(url==null)
            return

        RetrofitConnection().apiService.getCharactersByUrl(url).enqueue(object: Callback<GetCharacterResponse>{
            override fun onResponse(
                call: Call<GetCharacterResponse>,
                response: Response<GetCharacterResponse>
            ) {
                val characterList = response.body()?.results?: emptyList()
                showInRecycler(characterList)
                val info = response.body()?.info
                //showToast("info: ${info}")
                updateNavButtons(info)
            }

            override fun onFailure(call: Call<GetCharacterResponse>, t: Throwable) {
                //showToast("Error")
                showToast("Error en retrofit")
            }

        })


    }
    private fun getFromRetrofit() {

        RetrofitConnection().apiService.getCharacters().enqueue(object: Callback<GetCharacterResponse>{
            override fun onResponse(
                call: Call<GetCharacterResponse>,
                response: Response<GetCharacterResponse>
            ) {
                val characterList = response.body()?.results?: emptyList()
                showInRecycler(characterList)
                val info = response.body()?.info
                //showToast("info: ${info}")
                updateNavButtons(info)
            }

            override fun onFailure(call: Call<GetCharacterResponse>, t: Throwable) {
                //showToast("Error")
                showToast("Error en retrofit")
            }

        })
    }

    private fun updateNavButtons(info: Info?){


        var value : String =""
        info?.let{
            info?.prev?.let {
                value=info.prev.toString()
            }
        }
        Log.i("Debug","Value: ${value}, ${value.javaClass}")

        NavigationStateData.updateUrlPrev(value)
        NavigationStateData.updateUrlNext(info?.next)




        Log.i("URL","Next: ${NavigationStateData.getUrlNext()}")
        Log.i("URL","Prev: ${NavigationStateData.getUrlPrev()}")
        this.setUpViews()

    }


    override fun onDetach(){
        super.onDetach()
        ItemSelectedValue.clearUser()
    }

    /* Cargar datos remotos*/
    private fun showInRecycler(list:List<Result>){
        val myAdapter = MyAdapter(list.toUserItemList())

        with(binding){
            rvFragmentRecycler.layoutManager=LinearLayoutManager(requireContext())
            rvFragmentRecycler.adapter=myAdapter
        }
    }


}