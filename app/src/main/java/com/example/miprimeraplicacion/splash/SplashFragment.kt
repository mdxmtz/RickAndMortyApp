package com.example.miprimeraplicacion.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.miprimeraplicacion.R
import com.example.miprimeraplicacion.databinding.FragmentSplashBinding
import com.example.miprimeraplicacion.utils.extension_fun.getBooleanSharedPreferences


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        _binding= FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        redirection()
    }

    private fun redirection(){

        val userLogged=getBooleanSharedPreferences("login", false)



        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_recycleFragment);

        },3_000)

    }
}