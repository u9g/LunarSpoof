package dev.isxander.lunarspoof.websocket.auth.packet.impl

import dev.isxander.lunarspoof.websocket.auth.LunarAuthWebSocket
import dev.isxander.lunarspoof.websocket.auth.packet.LunarPacket
import gg.essential.api.utils.JsonHolder

class SPacketAuthenticatedRequest : LunarPacket() {
    override val name: String = "SPacketAuthenticatedRequest"
    lateinit var jwtKey: String
        private set

    override fun process(ws: LunarAuthWebSocket) {
        ws.acceptAuthentication(this)
    }

    override fun processJson(json: JsonHolder) {
        this.jwtKey = json.optString("jwtKey")
    }
}