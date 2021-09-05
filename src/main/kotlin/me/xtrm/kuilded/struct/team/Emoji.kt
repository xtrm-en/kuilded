package me.xtrm.kuilded.struct.team

data class Emoji(
    val id: Int,
    val name: String,
    val createdBy: String?,
    val createdAt: String?,
    val png: String,
    val webp: String,
    val apng: String?,
    val aliases: Array<String>? = emptyArray(),
    val teamId: String?,
    val isDeleted: Boolean?,
    val discordEmojiId: Long?,
    val discordSyncedAt: String?
)