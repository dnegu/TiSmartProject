package com.tismart.apptismart

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform