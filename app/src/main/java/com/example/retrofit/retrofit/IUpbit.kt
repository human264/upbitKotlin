package com.example.retrofit.retrofit

import com.example.retrofit.dto.SixtyMinuteCandleDTO
import com.example.retrofit.uitls.API
import com.example.retrofit.uitls.UPBIT_API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IUpbit {

    // 마지막 캔들 시각 (exclusive). 포맷 : yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss. 비워서 요청시 가장 최근 캔들
    @GET(UPBIT_API.SIXTY_MIN_CANDLE)
    fun getSixtyMinCandle(@Query("market") market: String, @Query("count") count:Int) : Call<SixtyMinuteCandleDTO>

    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm: String) : Call<JsonElement>



}