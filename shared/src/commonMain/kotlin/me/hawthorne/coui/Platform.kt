package me.hawthorne.coui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform