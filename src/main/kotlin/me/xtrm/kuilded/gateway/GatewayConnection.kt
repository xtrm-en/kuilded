package me.xtrm.kuilded.gateway

import me.xtrm.kuilded.GATEWAY_CONNECT_CLIENT
import me.xtrm.kuilded.GATEWAY_CONNECT_TEAM
import org.java_websocket.client.WebSocketClient
import java.net.URL

class GatewayConnection(targetId: String, teamTarget: Boolean) {

    lateinit var sid: String
    private val webSocketClient: WebSocketClient

    init {
        val baseUrl = if (teamTarget) GATEWAY_CONNECT_TEAM else GATEWAY_CONNECT_CLIENT
        val websocketUrl = URL(baseUrl.format(targetId))
        this.webSocketClient = GatewayClient(this, websocketUrl.toURI())
    }

    fun connect() {

    }
}