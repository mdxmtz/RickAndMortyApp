package com.example.miprimeraplicacion.data.retrofit.entity.get_character


import com.example.miprimeraplicacion.recycler.data.CharacterAddressItem
import com.example.miprimeraplicacion.recycler.data.CharacterItem

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {

    fun toUserItem(): CharacterItem {

        val address = CharacterAddressItem(
            name = this.location.name,
            url=this.location.url

        )

        return CharacterItem(
            name = this.name,
            imageURLValue = this.image,
            address = address,
            type=this.type
        )

    }
}