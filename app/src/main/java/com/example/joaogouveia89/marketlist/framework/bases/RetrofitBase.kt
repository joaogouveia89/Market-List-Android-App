package com.example.joaogouveia89.marketlist.framework.bases

import com.example.joaogouveia89.marketlist.BuildConfig
import com.google.gson.GsonBuilder
import com.example.joaogouveia89.marketlist.framework.constants.RetrofitConstants.TOKEN_HEADER
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit

class RetrofitBase <T>(private var functionalityDataInterface:Class<T>){
    private lateinit var retrofit: Retrofit
    private var dataInterfaceInstance: T? = null


    fun getDataInterfaceInstance():T?{
        if(dataInterfaceInstance == null)
            initRetrofit()
        return dataInterfaceInstance
    }

    private fun initRetrofit() {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(60, TimeUnit.SECONDS)

        if(BuildConfig.DEBUG){
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(loggingInterceptor)
        }

        val gsonBuilder = GsonBuilder()
            .excludeFieldsWithModifiers(
                Modifier.FINAL,
                Modifier.TRANSIENT,
                Modifier.STATIC
            )

        val gson = gsonBuilder.create()
        val gsonConverterFactory = GsonConverterFactory.create(gson)
        
        addAuthorizationHeader(builder)

        var urlBase = "ASDSADS"

        val httpClient = builder.build()

        retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .client(httpClient)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()

        dataInterfaceInstance = retrofit.create(functionalityDataInterface)
    }

    private fun addAuthorizationHeader(builder: OkHttpClient.Builder) {
        builder.addInterceptor(Interceptor {
            val original:Request = it.request()

            val request = original
                .newBuilder()
                .method(original.method(), original.body());

            fillAuthHeaders(request)
            
            val response = it.proceed(request.build())

            response
        })
    }

    private fun fillAuthHeaders(request: Request.Builder?) {
        request?.addHeader(TOKEN_HEADER,"asdsadsa")
    }

}