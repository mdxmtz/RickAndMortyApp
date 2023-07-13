package com.example.miprimeraplicacion.characterinfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.data.NavigationStateData
import com.example.miprimeraplicacion.databinding.FragmentCharacterBinding
import com.example.miprimeraplicacion.databinding.FragmentRecycleBinding

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_character, container, false
        _binding= FragmentCharacterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpView()

    }

    private fun setUpView() {
        var character=NavigationStateData.getCharacterSelected()
        binding.tvFragmentCharacterName.text=character.name

        try {
            val imageURLValue=NavigationStateData.getCharacterSelected().imageURLValue
            Glide.with(requireContext()).load(imageURLValue).into(binding.imageView)
        }catch (e: Exception ){
            Log.w("Royal","URL: Message: "+e.message)

        }
    }

}