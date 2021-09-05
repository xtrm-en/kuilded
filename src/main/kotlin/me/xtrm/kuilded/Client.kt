package me.xtrm.kuilded

import me.xtrm.kuilded.event.Event
import me.xtrm.kuilded.event.EventHandlers
import me.xtrm.kuilded.gateway.GatewayConnection
import kotlin.reflect.KClass

class Client(clientId: String) {
    private val clientGateway: GatewayConnection = GatewayConnection(clientId, false)
    private val teamGateways: Array<GatewayConnection> = emptyArray()

    val eventHandlers: MutableMap<KClass<out Event>, EventHandlers<*>> = LinkedHashMap()

    init {
        clientGateway.connect()
    }

    fun getEmojis() {
        TODO("Unimplemented yet")
    }

    fun getTeams() {
        TODO("Unimplemented yet")
    }

    fun getPrivateChannels() {
        TODO("Unimplemented yet")
    }

    inline fun <reified T: Event> on(noinline handler: (T) -> Unit) {
        val handlers = eventHandlers.getOrDefault(T::class, EventHandlers<T>())
        (handlers.list as ArrayList<(T) -> Unit>).add(handler)
        eventHandlers[T::class] = handlers
    }

}