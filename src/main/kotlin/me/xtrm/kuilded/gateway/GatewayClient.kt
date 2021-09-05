package me.xtrm.kuilded.gateway

import me.xtrm.kuilded.gateway.payload.PayloadHandler
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

class GatewayClient(val connection: GatewayConnection, uri: URI): WebSocketClient(uri) {

    private val payloadHandler = PayloadHandler(this)

    override fun onOpen(handshakedata: ServerHandshake?) {
        handshakedata?.let { println("${it.httpStatus} / ${it.httpStatusMessage}") }
    }

    override fun onMessage(message: String?) {
        message?.let { payloadHandler.handlePayload(it) }
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        println(">-{ CLOSED GATEWAY }-<")
        println("Code: $code")
        println("Reason: ${reason ?: "None"}")
        println("Remote: $remote")
    }

    override fun onError(ex: Exception?) {
        ex?.printStackTrace()
    }
}