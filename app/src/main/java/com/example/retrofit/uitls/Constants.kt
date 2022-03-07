package com.example.retrofit.uitls

object Constants {
    const val TAG: String = "로그"


}

enum class SEARCH_TYPE {
    PHOTO,
    USER
}

enum class RESPONSE_STATE{
    OKAY,FAIL
}

object API {
    const val BASE_URL: String = "https://api.unsplash.com/"
    const val SEARCH_PHOTO : String = "search/photos"
    const val SEARCH_USERS : String = "search/users"
    const val CLIENT_ID: String = "3uckuR_mIKKB5a-qJSEX2tnxvoqs-TqpxSATZUUvh08"
}

object UPBIT_API {
    const val BASE_URL: String = "https://api.upbit.com/v1/"
    const val ONE_MIN_CANDLE: String = "candles/minutes/1"
    const val SIXTY_MIN_CANDLE: String = "candles/minutes/60"
}