package com.timilite.firstkmpproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform