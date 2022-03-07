package com.example.retrofit.service

import android.provider.ContactsContract
import com.example.retrofit.dto.DataDto
import com.example.retrofit.dto.SixtyMinuteCandleDTO
import com.example.retrofit.dto.SixtyMinuteCandleDTOItem

class Lond(data:SixtyMinuteCandleDTO) {
    val data2:SixtyMinuteCandleDTO = data
    var dataDtos:MutableList<DataDto> = ArrayList()
    lateinit var dataDto:DataDto

    fun setReturns():MutableList<DataDto> {

        var temp: SixtyMinuteCandleDTOItem = data2[data2.size - 1]

        for(data in data2) {
            dataDto = DataDto(date = data.candleDateTimeKst,
                close = data.tradePrice,
                open = data.openingPrice,
                high = data.highPrice,
                low = data.lowPrice,
                returns = null,
                volume = data.candleAccTradeVolume
                )
            dataDtos.apply {
                add(dataDto)
            }
        }


        return dataDtos
    }

}


