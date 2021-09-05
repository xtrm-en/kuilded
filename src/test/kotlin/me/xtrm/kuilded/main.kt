package me.xtrm.kuilded

import me.xtrm.kuilded.event.defaults.MessageEvent
import me.xtrm.kuilded.event.defaults.Type

fun main() {
    val email = System.getenv("KUILDED_TEST_EMAIL")
    val pass = System.getenv("KUILDED_TEST_PASS")

    val client = ClientBuilder.createClient(email, pass)
    client.on<MessageEvent> {
        if (it.type == Type.RECEIVED) {
            if(it.)
        }
    }
}