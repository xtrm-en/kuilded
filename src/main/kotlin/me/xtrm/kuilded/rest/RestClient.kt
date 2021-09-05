package me.xtrm.kuilded.rest

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class RestClient(userAgent: String) {

    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .build()

    fun get(endpoint: String, params: Map<String, Any>?){

    }
}