package com.example.miprimeraplicacion.recycler.data

data class CharacterItem(
    val name : String="Sin nombre",
    val type: String ="Sin tipo",
    val locationName: String="",

    val imageURLValue : String = "Empty",

    val address: CharacterAddressItem = CharacterAddressItem(
        "Earth")

)

data class CharacterAddressItem(
    val name: String = "Sin nombre",
    val url:String=""
){

}