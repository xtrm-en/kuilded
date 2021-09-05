package me.xtrm.kuilded.gateway.payload

import com.fasterxml.jackson.databind.ObjectMapper
import me.xtrm.kuilded.gateway.GatewayClient

class PayloadHandler(private val client: GatewayClient, private val mapper: ObjectMapper = ObjectMapper()) {
    private val handlerMap = mapOf(
        0 to PayloadHandler::handleHello
    )

    fun handlePayload(data: String) {
        val index = data.indexOf('{')
        val payloadId = if (index == -1) data.toInt()
        else data.substring(0, index).toInt()

        val function = handlerMap.getOrDefault(payloadId, PayloadHandler::handleVoid)

        if (index == -1) {
            function.call(emptyMap<String, Any>())
            return
        }

        val json = data.substring(index)
        val map = mapper.readValue(json, Map::class.java)

        function.call(map)
    }

    private fun handleHello(data: Map<String, Any>) {
        client.connection.sid = data["sid"] as String

        HeartbeatHandler(client, data["pingInterval"] as Long)
    }

    private fun handleVoid(data: Map<String, Any>) {}
}