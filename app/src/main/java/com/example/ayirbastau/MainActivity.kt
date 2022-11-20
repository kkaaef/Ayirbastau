package com.example.ayirbastau

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL



class MainActivity : AppCompatActivity() {
    private var inputAmount: EditText? = null
    private var choosedCurrency: Spinner? = null
    private var wantedCurrency: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputAmount = findViewById(R.id.enterAmount)
        choosedCurrency = findViewById(R.id.choosedCurrency)
        wantedCurrency =  findViewById(R.id.wantedCurrency)
    }

    fun Ayirbastau(view : View) {
        val inputAmount = inputAmount?.text
        val wantedCurrency = wantedCurrency?.selectedItem.toString()
        val choosedCurrency = choosedCurrency?.selectedItem.toString()
        val url = "https://api.coindesk.com/v1/bpi/currentprice/$choosedCurrency.json"
        doAsync {
            //Отправляем ХТТП запрос заходим и тянем джос сюда
            val apiResponse = URL(url).readText()
            val currency =JSONObject(apiResponse).getJSONArray("$wantedCurrency")
            val index = currency.getJSONObject(0).getString("rate")?.toInt()

        }

    }
}

