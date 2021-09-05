package me.xtrm.kuilded.rest

import com.fasterxml.jackson.databind.ObjectMapper
import me.xtrm.kuilded.API_BASE
import me.xtrm.kuilded.ID_COOKIE_NAME
import me.xtrm.kuilded.struct.user.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URL
import java.util.concurrent.TimeUnit
import kotlin.reflect.KFunction3

class RestClient(userAgent: String) {

    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .cookieJar(CookieJar())
        .build()

    private fun buildRequest(method: Method = Method.GET, endpoint: String, params: Map<String, Any> = emptyMap()): Request {
        return method.function.invoke(this, URL(API_BASE + endpoint), params).build()
    }

    private fun execute(request: Request): Response {
        return httpClient.newCall(request).execute()
    }

    private inline fun <reified T> request(method: Method = Method.GET, endpoint: String, params: Map<String, Any> = emptyMap()): T? {
        val resp = execute(buildRequest(method, endpoint, params))
        return resp.body?.let { ObjectMapper().readValue(it.string(), T::class.java) }
    }

    fun login(email: String, password: String): Pair<User?, String> {
        val jar: CookieJar = httpClient.cookieJar as CookieJar
        jar.clear()

        val user: User? = request<User>(Method.POST, API_LOGIN, mapOf("email" to email, "password" to password))

        val token = jar.getAll().firstOrNull { it.name == ID_COOKIE_NAME }?.value ?: ""
        return user?.let {
            Pair(it, token)
        } ?: Pair(null, token)
    }

    enum class Method(val function: KFunction3<RestClient, URL, Map<String, Any>, Request.Builder>) {
        GET(RestClient::createGet),
        POST(TODO("")),
        PUT(),
        DELETE(),
        PATCH()
    }

    private fun createGet(url: URL, map: Map<String, Any>): Request.Builder {

    }
}