package com.example.retrofit.retrofit

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import com.example.retrofit.dto.SixtyMinuteCandleDTO
import com.example.retrofit.uitls.API
import com.example.retrofit.uitls.RESPONSE_STATE
import com.example.retrofit.uitls.SEARCH_TYPE
import com.example.retrofit.uitls.UPBIT_API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManagerForUpbit {
    companion object {
        var instance = RetrofitManagerForUpbit()
    }

    //http 콜 만들
    private val iRetrofitManagerForUpbit: IUpbit? = RetrofitClientForUpbit.getClient(UPBIT_API.BASE_URL)?.create(IUpbit::class.java)

    //사진 검색 api 호출
    fun getSixtyMinuteCandle(market: String?, count: Int?, completion: (RESPONSE_STATE, String) -> Unit) {
//        val to = to.let { it }?:""

        val call = iRetrofitManagerForUpbit?.getSixtyMinCandle(market!!, count!!) ?:return

        call.enqueue(object : retrofit2.Callback<SixtyMinuteCandleDTO>{
            override fun onResponse(call: Call<SixtyMinuteCandleDTO>, response: Response<SixtyMinuteCandleDTO>) {
                Log.d(TAG, "RestoriftManager - onResponse() called / response ${response.body().toString()}")
                completion(RESPONSE_STATE.OKAY, response.body().toString())
                println("=========")
            }

            override fun onFailure(call: Call<SixtyMinuteCandleDTO>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
                completion(RESPONSE_STATE.FAIL, t.toString())
            }

        })

    }




}