package br.com.pedrobrasileiro.mobile.cryptoprices

import br.com.pedrobrasileiro.mobile.cryptoprices.interfaces.PriceEndpoint
import br.com.pedrobrasileiro.mobile.cryptoprices.models.Price
import retrofit2.Call

class PriceService {
    var path = "https://api.coinstats.app"
    fun eth() : Call<List<Price>> {
        var retrofitService = NetworkUtils.getRetrofitInstance(path);

        var endpoint = retrofitService.create(PriceEndpoint::class.java);
        var callback = endpoint.marketsEth();

        return callback;
    }
}