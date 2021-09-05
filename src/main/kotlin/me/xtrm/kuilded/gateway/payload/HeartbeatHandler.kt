package me.xtrm.kuilded.gateway.payload

import me.xtrm.kuilded.gateway.GatewayClient
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class HeartbeatHandler(private val client: GatewayClient, private val delay: Long) {
    private val executor = Executors.newSingleThreadScheduledExecutor()

    init {
        executor.schedule(this::handleHeartbeat, delay, TimeUnit.MILLISECONDS)
    }

    private fun handleHeartbeat() {
        client.send("2")
    }
}