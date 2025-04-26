package com.nikolai.instagramhelper

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform