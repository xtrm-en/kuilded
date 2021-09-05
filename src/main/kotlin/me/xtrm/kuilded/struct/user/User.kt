package me.xtrm.kuilded.struct.user

import me.xtrm.kuilded.struct.team.Emoji
import java.net.URL
import java.util.*

data class User(
    val id: String,
    val name: String,
    val subdomain: String?,
    val type: String? = "user",
    val aliases: Array<Any> = emptyArray(),
    val email: String?,
    val serviceEmail: String?,
    val profilePicture: URL,
    val profilePictureSm: URL,
    val profilePictureLg: URL,
    val profilePictureBlur: URL,
    val profileBannerSm: URL?,
    val profileBannerLg: URL?,
    val profileBannerBlur: URL?,
    val joinDate: String,
    val steamId: String?,
    val userStatus: UserStatus?,
    val userPresenceStatus: Int,
    val userTransientStatus: UserTransientStatus?,
    val moderationStatus: Any?,
    val aboutInfo: AboutInfo?,
    val lastOnline: String?,
    val stonks: Int?,
    val flairInfos: Array<Any> = emptyArray()
)

data class UserStatus(
    val content: Any?,
    val customReactionId: Int?,
    val customReaction: Emoji?
)

data class UserTransientStatus(
    val id: Int,
    val gameId: Int?,
    val name: String?,
    val type: String,
    val startedAt: String,
    val guildedClientId: UUID
)

data class AboutInfo(
    val bio: String,
    val tagLine: String
)