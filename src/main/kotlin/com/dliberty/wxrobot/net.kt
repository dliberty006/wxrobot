package com.dliberty.wxrobot

import cn.fuser.vx.wxbot.JSONRequest
import cn.fuser.vx.wxbot.Method
import com.alibaba.fastjson.annotation.JSONField
import java.net.URLEncoder

class ShortenURL(keyword: String) {
    private val encoding = "utf-8"
    @JSONField(name = "url")
    val url = buildURL(keyword)

    private fun buildURL(keyword: String): String {
        val sb = StringBuilder(Config.shortenReqURL)
        sb.append("?q=")
        val v = URLEncoder.encode(keyword, encoding)
        sb.append(v)
        return sb.toString()
    }
}

class ShortURLRequest(keyword: String) : JSONRequest<ShortenURL>(Config.shortenURL, Method.POST, ShortenURL(keyword))
data class ShortenResp(@JSONField(name = "err_no") val errNo: Int, val msg: String, val data: String)
