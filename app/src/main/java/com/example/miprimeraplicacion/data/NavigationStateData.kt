package com.example.miprimeraplicacion.data

import com.example.miprimeraplicacion.recycler.data.CharacterItem

object NavigationStateData {

    private var urlNext: String =""
    private var urlPrev: String = ""
    private lateinit var characterSelected: CharacterItem



    fun updateUrlNext(url:String?){
        if(url==null)
            urlNext=""
        else
            urlNext=url

    }

    fun updateUrlPrev(url:String?){
        if(url==null)
            urlPrev=""
        else
            urlPrev=url
    }

    fun getUrlNext():String{
        return urlNext
    }

    fun getUrlPrev():String{
        return urlPrev
    }

    fun setCharacterSelected(userItem: CharacterItem) {
        this.characterSelected=userItem

    }

    fun getCharacterSelected():CharacterItem{
        return characterSelected
    }
}