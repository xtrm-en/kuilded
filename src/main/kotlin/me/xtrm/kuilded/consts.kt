package me.xtrm.kuilded

const val API_BASE = "https://guilded.gg/api"
const val API_LOGIN = "$API_BASE/login"

const val GATEWAY_BASE = "wss://api.guilded.gg"
const val GATEWAY_CONNECT_BASE = "$GATEWAY_BASE/socket.io/?EIO=3&transport=websocket"
const val GATEWAY_CONNECT_CLIENT = "$GATEWAY_CONNECT_BASE&jwt=undefined&guildedClientId=%s"
const val GATEWAY_CONNECT_TEAM = "$GATEWAY_CONNECT_BASE&teamId=%s"