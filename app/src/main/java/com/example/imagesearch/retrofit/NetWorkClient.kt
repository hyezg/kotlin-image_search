package com.example.imagesearch.retrofit


//import com.example.imagesearch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetWorkClient {

    //서비스 URL
    private const val IMAGE_BASE_URL = "https://dapi.kakao.com/v2/search/image"
    private const val API_KEY = "49f21a3e387c2a825f6c3393d00b94cc"

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()

        //통신이 잘 안될 때 디버깅을 위한 용도
        /*if (BuildConfig.DEBUG)
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        else
            interceptor.level = HttpLoggingInterceptor.Level.NONE*/

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    private val imageRetrofit = Retrofit.Builder()
        .baseUrl(IMAGE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()

    //네트워크 인터페이스 타입
    val kakaoSearch: NetWorkInterface = imageRetrofit.create(NetWorkInterface::class.java)

}