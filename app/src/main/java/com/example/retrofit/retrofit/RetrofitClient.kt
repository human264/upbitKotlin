package com.example.retrofit.retrofit

import android.content.ContentValues.TAG
import android.util.Log
import com.example.retrofit.uitls.API
import com.example.retrofit.uitls.isJsonArray
import com.example.retrofit.uitls.isJsonObject
import com.google.gson.JsonObject
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

//싱글턴
object RetrofitClient {
    // 레트로핏 클라이언트 선언

    private var retrofitClient: Retrofit? = null


    //레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called")

        var loggingIntercepttor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(TAG, "RetrofitClient - log() message : $message")

                when {
                    message.isJsonObject()
                        -> Log.d(TAG, JSONObject(message).toString(4))
                    message.isJsonArray()
                        -> Log.d(TAG, JSONObject(message).toString(4))
                    else -> {
                        try {
                            Log.d(TAG, JSONObject(message).toString(4))
                        } catch (e: Exception) {
                            Log.d(TAG, message)
                        }
                    }
                }
            }
        })
        // 기본 파라메터 추가
        loggingIntercepttor.setLevel(HttpLoggingInterceptor.Level.BODY)

        // logging interceptor 추가
        var client = OkHttpClient.Builder().addInterceptor(loggingIntercepttor)

        // 기본 파라메터 인터셉터 설정
        var baseParameterInterceptor: Interceptor = (object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                //오리지날 리퀘스트
                val originalRequest = chain.request()

                //Query Pamametor 추가하기
                val addedUrl = originalRequest.url.newBuilder().addQueryParameter("client_id", API.CLIENT_ID)
                    .build()

                val finalRequest = originalRequest.newBuilder()
                    .url(addedUrl)
                    .method(originalRequest.method, originalRequest.body)
                    .build()

                return chain.proceed(finalRequest)
            }
        })

        client.addInterceptor(baseParameterInterceptor)

        client.connectTimeout(10, TimeUnit.SECONDS)
        client.readTimeout(10, TimeUnit.SECONDS)
        client.writeTimeout(10, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)

        if(retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
        }

        return retrofitClient
    }

}