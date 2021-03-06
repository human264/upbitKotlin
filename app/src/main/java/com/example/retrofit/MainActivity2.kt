package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.retrofit.dto.SixtyMinuteCandleDTO
import com.example.retrofit.retrofit.RetrofitManager
import com.example.retrofit.retrofit.RetrofitManagerForUpbit
import com.example.retrofit.service.Lond
import com.example.retrofit.uitls.RESPONSE_STATE

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var btn_search = findViewById<Button>(R.id.button)

        var sixtyMinCandleDTO: SixtyMinuteCandleDTO = SixtyMinuteCandleDTO()

        btn_search.setOnClickListener {
            RetrofitManagerForUpbit.instance.getSixtyMinuteCandle("KRW-BTC",10, completion = {
                    responseState, responseBody ->
                when(responseState) {
                    RESPONSE_STATE.OKAY -> {
                        Toast.makeText(this,"Api 호출 성공. :", Toast.LENGTH_SHORT).show()
                        sixtyMinCandleDTO = responseBody
                    }

                    RESPONSE_STATE.FAIL -> {
                        Toast.makeText(this,"Api 호출 에러입니다.: ", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }


        var button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            var load = Lond(sixtyMinCandleDTO)
             load.setValueInitialized()
            println("=================")
            print(load.setValueInitialized().toString())
            println("=================")
        }




    }




}