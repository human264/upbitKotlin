package com.example.retrofit.service

import com.example.retrofit.dto.DataDto
import com.example.retrofit.dto.SixtyMinuteCandleDTO
import com.example.retrofit.dto.SixtyMinuteCandleDTOItem
import java.lang.Math.E
import java.lang.Math.log
import kotlin.math.ln

class Lond(data:SixtyMinuteCandleDTO) {
    val datas:SixtyMinuteCandleDTO = data
    var dataDtos:MutableList<DataDto> = ArrayList()
    var dataDto:DataDto = DataDto(null, null, null, null, null, null, null, null)
    var cumresult:Double?=0.0

    fun setValueInitialized():MutableList<DataDto> {
        var temp: SixtyMinuteCandleDTOItem = datas[datas.size - 1]

        for (i:Int in 0..datas.size-1) {
            dataDto = DataDto(date = datas.get(i).candleDateTimeKst,
                close = datas.get(i).tradePrice,
                open = datas.get(i).openingPrice,
                high = datas.get(i).highPrice,
                low = datas.get(i).lowPrice,
                returns = setReturns(i, datas),
                creturns = setCreturns(i, datas),
                volume = datas.get(i).candleAccTradeVolume)
           dataDtos.add(dataDto)
        }

        return dataDtos
    }

    private fun setCreturns(index: Int, datas: SixtyMinuteCandleDTO):Double? {
        var preValue:Double?
        var value:Double?=0.0

        for (index:Int in 0 until dataDtos.size) {
            if(index > 0) {
                preValue = dataDtos.get(index-1).close
                value = dataDtos.get(index).close
                if (value != null) {
                    cumresult = cumresult?.plus(ln(value / preValue!!))
                }
            }
        }
        return cumresult?.let { Math.exp(it) }
    }

    fun setReturns(index: Int, datas: SixtyMinuteCandleDTO): Double? {
            var preValue:Double?
            var value:Double?=0.0
            var result:Double?=0.0
            if(index > 0) {
                preValue = datas.get(index-1).tradePrice
                value = datas.get(index).tradePrice
                if (value != null) {
                    result = log(value / preValue!!)
                }
                return result
            }
        return 0.0
    }





}


