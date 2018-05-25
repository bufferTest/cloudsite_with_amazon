package com.softuvo.cloudsight.data

import io.reactivex.Observable
import retrofit2.Retrofit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.*
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder
import com.softuvo.cloudsight.BuildConfig

import com.softuvo.cloudsight.model.ResponsePojo
import com.softuvo.cloudsight.model.CloudSightResponsePojo
import com.softuvo.cloudsight.model.ItemSearchResponse

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import java.util.HashMap

/*
 * Created by Softuvo-Network on 12/20/2017.
 */
interface ApiService {
    companion object Factory {
        val LOCALE = "image_request[locale]"
        val IMAGE = "image_request[image]"
        val AUTHORIZATIONKEY = "CloudSight G5pX9wkzNRi-2enSOQ5peA"

        val interceptor = HttpLoggingInterceptor()

        fun create(): ApiService {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(360, TimeUnit.SECONDS)
                    .readTimeout(360, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()

            return Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
//                            GsonConverterFactory.create(gson)
//                    SimpleXmlConverterFactory.create()
                            ScalarsConverterFactory.create()
                    )
                    .baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
                    .build().create(ApiService::class.java);
        }


        val gson = GsonBuilder()
                .setLenient()
                .create()
        fun createCloudSight(): ApiService {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(360, TimeUnit.SECONDS)
                    .readTimeout(360, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()

            return Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create(gson)

                    )
                    .baseUrl(BuildConfig.CLOUD_SIGHT_BASE_URL).client(okHttpClient)
                    .build().create(ApiService::class.java);
        }

    }

    @GET
    fun getProductResults(@Url url: String): Observable<String>

    @Multipart
    @POST("/image_requests")
    fun uploadImage(@Header("authorization") authorization: String, @PartMap map: HashMap<String, RequestBody>, @Part file: MultipartBody.Part): Observable<CloudSightResponsePojo>


    @GET("/image_responses/{token}")
    fun imageResult(@Header("authorization") authorization: String, @Path("token") token: String): Observable<CloudSightResponsePojo>

}
