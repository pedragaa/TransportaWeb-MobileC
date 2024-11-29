package br.senai.sp.jandira.transportaweb.service

import br.senai.sp.jandira.transportaweb.model.GeocodingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {

    @GET("maps/api/geocode/json")
    suspend fun getCoordinates(
        @Query("address") address: String,
        @Query("key") apiKey: String
    ): GeocodingResponse

}