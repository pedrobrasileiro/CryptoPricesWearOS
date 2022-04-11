package br.com.pedrobrasileiro.mobile.cryptoprices.interfaces

import br.com.pedrobrasileiro.mobile.cryptoprices.models.Price
import retrofit2.Call
import retrofit2.http.GET

interface PriceEndpoint {

    @GET("/public/v1/markets?coinId=ethereum")
    fun marketsEth() : Call<List<Price>>
}
