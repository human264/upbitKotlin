package com.example.retrofit.retrofit

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import com.example.retrofit.uitls.API
import com.example.retrofit.uitls.RESPONSE_STATE
import com.example.retrofit.uitls.SEARCH_TYPE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {
    companion object {
        var instance = RetrofitManager()

    }

    //http 콜 만들
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    //사진 검색 api 호출
    fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, String) -> Unit) {
        val term = searchTerm.let {
            it
        }?:""

        val call = iRetrofit?.searchPhotos(searchTerm= term) ?:return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RestoriftManager - onResponse() called / response ${response.body().toString()}")

                completion(RESPONSE_STATE.OKAY, response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")
                completion(RESPONSE_STATE.FAIL, t.toString())
            }

        })

    }




}