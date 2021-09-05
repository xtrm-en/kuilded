package me.xtrm.kuilded

import me.xtrm.kuilded.rest.RestClient

object ClientBuilder {

    private const val USER_AGENT =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Guilded/1.0.9105465-release " +
                "Chrome/80.0.3987.163 " +
                "Electron/8.5.2 " +
                "Safari/537.36"

    private val restClient = RestClient(USER_AGENT)

    fun createClient(email: String, password: String): Client {
        val pair = restClient.login(email, password)
        return createClient(pair.second)
    }

    fun createClient(authCookie: String): Client {
        return Client(authCookie)
    }

}