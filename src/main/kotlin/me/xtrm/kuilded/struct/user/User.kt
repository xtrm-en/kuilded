package me.xtrm.kuilded.struct.user

import java.net.URL

data class User(
    val id: String,
    val name: String,
    val type: String = "user",
    val aliases: Array<String> = emptyArray(),
    val profilePictureSm: URL?,
    val profilePicture: URL?,
    val profilePictureLg: URL?,
    val profilePictureBlur: URL?,
    val profileBannerBlur: URL?,
    val profileBannerLg: URL?,
    val joinDate: String,
    val steamId: Any?,
    val moderationStatus: Any?,
    val aboutInfo: Any?,
    val lastOnline: String?
)