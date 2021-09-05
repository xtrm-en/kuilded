package me.xtrm.kuilded.event

class EventHandlers<T: Event>(val list: ArrayList<in (T) -> Unit> = ArrayList())