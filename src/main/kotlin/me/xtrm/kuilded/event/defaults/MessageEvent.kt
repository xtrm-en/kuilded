package me.xtrm.kuilded.event.defaults

import me.xtrm.kuilded.event.Event
import me.xtrm.kuilded.struct.IdentityHolder
import me.xtrm.kuilded.struct.channel.AbstractChannel

data class MessageEvent(val type: Type, val content: MessageContent, val sender: IdentityHolder, val channel: AbstractChannel): Event()

enum class Type {
    RECEIVED, SENT
}