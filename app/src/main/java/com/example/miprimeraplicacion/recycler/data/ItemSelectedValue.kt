package com.example.miprimeraplicacion.recycler.data

import com.example.miprimeraplicacion.data.User

object ItemSelectedValue {

    var userItemSelected = CharacterItem()

    init {
        userItemSelected = CharacterItem()
    }

    fun clearUser() {
         userItemSelected = CharacterItem()
    }

    fun selectUser(user:CharacterItem){
        userItemSelected = user
        //igual a UserIteam()

    }

    fun getUser() = userItemSelected


}