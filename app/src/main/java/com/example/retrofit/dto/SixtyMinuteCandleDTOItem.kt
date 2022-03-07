package com.example.retrofit.dto


import com.google.gson.annotations.SerializedName

data class SixtyMinuteCandleDTOItem(
    @SerializedName("candle_acc_trade_price")
    val candleAccTradePrice: Double?,
    @SerializedName("candle_acc_trade_volume")
    val candleAccTradeVolume: Double?,
    @SerializedName("candle_date_time_kst")
    val candleDateTimeKst: String?,
    @SerializedName("candle_date_time_utc")
    val candleDateTimeUtc: String?,
    @SerializedName("high_price")
    val highPrice: Double?,
    @SerializedName("low_price")
    val lowPrice: Double?,
    @SerializedName("market")
    val market: String?,
    @SerializedName("opening_price")
    val openingPrice: Double?,
    @SerializedName("timestamp")
    val timestamp: Long?,
    @SerializedName("trade_price")
    val tradePrice: Double?,
    @SerializedName("unit")
    val unit: Int?
)