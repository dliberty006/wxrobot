package com.dliberty.wxrobot

enum class HttpMethod {
    GET, POST
}

open class BaseRequest(open val url: String, val method: HttpMethod = HttpMethod.GET)
