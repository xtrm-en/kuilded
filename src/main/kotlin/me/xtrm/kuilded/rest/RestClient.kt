package me.xtrm.kuilded.rest

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.net.URL
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

class RestClient(userAgent: String) {

    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .build()

    fun <T> request(method: Method = Method.GET, endpoint: String, params: Map<String, Any> = emptyMap(), responseTemplate: KClass<*> = Map::class): T? {
        httpClient.newCall()
    }

    fun login(email: String, password: String): String {
        return request<Map<String, Any>>(Method.POST, API_LOGIN, mapOf("email" to email, "password" to password))?.let {
            it["guilded_mid"] as String
        } ?: ""
    }

    enum class Method(val function: (url: URL, map: Map<String, Any>) -> Request.Builder) {
        GET({
            val builder: Request.Builder = Request.Builder()
            builder.get()
            builder.
            builder
        }),
        POST(TODO("")),
        PUT(),
        DELETE(),
        PATCH()
    }
}