package br.com.pedrobrasileiro.mobile.cryptoprices

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.pedrobrasileiro.mobile.cryptoprices.databinding.ActivityMainBinding
import br.com.pedrobrasileiro.mobile.cryptoprices.models.Price
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat
import java.util.*

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReload.setOnClickListener {
            binding.labelEthValue.text = baseContext.getString(R.string.loading)
            getData()
        }

        getData()
    }

    private fun getData() {
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 5
        format.currency = Currency.getInstance("BRL")

        val callback = PriceService().eth()

        callback.enqueue(object : Callback<List<Price>> {
            override fun onFailure(call: Call<List<Price>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Price>>, response: Response<List<Price>>) {
                Log.d("onResponse body", response.body().toString())


                val price = response.body()?.filter { it.pair == "ETH/BRL" }?.get(0)

                binding.labelEthValue.text = format.format(price?.price)
            }
        })
    }
}