package me.xtrm.kuilded.event

@FunctionalInterface
interface EventHandler<T: Event> {
    fun handle(event: T)
}