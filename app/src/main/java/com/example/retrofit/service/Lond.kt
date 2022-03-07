package com.example.retrofit.service

import com.example.retrofit.dto.DataDto
import com.example.retrofit.dto.SixtyMinuteCandleDTO
import com.example.retrofit.dto.SixtyMinuteCandleDTOItem

class Lond(data:SixtyMinuteCandleDTO) {

    lateinit var dataDtos:MutableList<DataDto>
    lateinit var dataDto:DataDto

    fun setReturns(datas:SixtyMinuteCandleDTO):MutableList<DataDto> {

        var temp: SixtyMinuteCandleDTOItem = datas[datas.size - 1]

        for(data in datas) {
            dataDto.close = data.tradePrice
            dataDtos.add(dataDto)
        }


        return dataDtos
    }

}


