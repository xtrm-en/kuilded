package me.xtrm.kuilded.rest

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieJar : CookieJar {

    private val cookieMap: MutableMap<HttpUrl, MutableList<Cookie>> = HashMap()

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return cookieMap.getOrDefault(url, ArrayList())
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        cookieMap.computeIfAbsent(url) { ArrayList() }.addAll(cookies)
    }

    fun getAll(): List<Cookie> {
        val list = ArrayList<Cookie>()
        cookieMap.values.forEach {
            list.addAll(it)
        }
        return list
    }

    fun clear() {
        cookieMap.clear()
    }
}