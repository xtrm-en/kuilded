package me.xtrm.kuilded.rest

import com.fasterxml.jackson.databind.ObjectMapper
import me.xtrm.kuilded.API_BASE
import me.xtrm.kuilded.ID_COOKIE_NAME
import me.xtrm.kuilded.struct.user.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.apache.http.HttpHeaders
import org.apache.http.NameValuePair
import org.apache.http.client.utils.URLEncodedUtils
import org.apache.http.message.BasicNameValuePair
import java.net.URL
import java.util.concurrent.TimeUnit
import kotlin.reflect.KFunction3

open class RestClient(private val userAgent: String) {

    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .cookieJar(CookieJar())
        .build()

    private var authCookie: String? = null

    private fun buildRequest(method: Method = Method.GET, endpoint: String, params: Map<String, Any> = emptyMap()): Request {
        val builder: Request.Builder = method.function.invoke(this, URL(API_BASE + endpoint), params)
        builder.header(HttpHeaders.USER_AGENT, userAgent)
        authCookie?.let {
            builder.header("Cookie", "$ID_COOKIE_NAME=$it")
        }
        return builder.build()
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
        val builder = Request.Builder()
        val list = ArrayList<BasicNameValuePair>()
        map.map { BasicNameValuePair(it.key, it.value.toString()) }.forEach(list::add)

        val query = URLEncodedUtils.format(list, Charsets.UTF_8)
        builder.url(URL("$url?$query"))
        builder.get()
        return builder
    }
}