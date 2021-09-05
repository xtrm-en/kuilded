package me.xtrm.kuilded

import me.xtrm.kuilded.gateway.GatewayConnection

class Client(clientId: String) {
    private val clientGateway: GatewayConnection = GatewayConnection(clientId, false)
    private val teamGateways: Array<GatewayConnection> = emptyArray()

    init {
        clientGateway.connect()
    }


}