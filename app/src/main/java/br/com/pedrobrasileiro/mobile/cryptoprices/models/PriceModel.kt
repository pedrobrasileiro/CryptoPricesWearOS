package br.com.pedrobrasileiro.mobile.cryptoprices.models

//import com.google.gson.annotations.SerializedName

public data class Price(
//    @SerializedName("price")
    var price : Double,
//    @SerializedName("exchange")
    var exchange : String,
//    @SerializedName("pair")
    var pair : String,
//    @SerializedName("pairPrice")
    var pairPrice : Double,
//    @SerializedName("volume")
    var volume : Double
)