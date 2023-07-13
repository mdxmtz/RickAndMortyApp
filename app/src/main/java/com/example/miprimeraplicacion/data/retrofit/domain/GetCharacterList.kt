package com.example.miprimeraplicacion.data.retrofit.domain

import com.example.miprimeraplicacion.data.retrofit.entity.get_character.GetCharacterResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface GetCharacterList {

    //https://rickandmortyapi.com/api/


    @GET("character")
    fun getCharacters() : Call<GetCharacterResponse>

    /*@GET("character")
    fun getPageOfCharacteres(@Query("page")  page:Int):Call<GetCharacterResponse>
*/
    @GET
    fun getCharactersByUrl(@Url url: String?): Call<GetCharacterResponse>



}