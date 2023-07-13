package com.example.miprimeraplicacion.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miprimeraplicacion.databinding.ActivityLoginNcActivityBinding
import com.example.miprimeraplicacion.utils.extension_fun.showToast

class MainNavigationComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginNcActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login_nc_activity)

        binding= ActivityLoginNcActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }



}