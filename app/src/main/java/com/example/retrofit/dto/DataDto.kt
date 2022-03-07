package com.example.retrofit.dto

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class DataDto(

    var date: LocalDateTime?,
    var open: Double?,
    var high: Double?,
    var low: Double?,
    var close: Double?,
    var returns: Double?,
    val volume: Double?,
    var value: Double?

)
