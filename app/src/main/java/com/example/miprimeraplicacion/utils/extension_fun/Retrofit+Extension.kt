package com.example.miprimeraplicacion.utils.extension_fun


import com.example.miprimeraplicacion.data.retrofit.entity.get_character.Result
import com.example.miprimeraplicacion.recycler.data.CharacterItem


fun List<Result>.toUserItemList():List<CharacterItem>{

    val userItemList = mutableListOf<CharacterItem>()

    this.forEach {
        userItemList.add(it.toUserItem())
    }

    return userItemList

}