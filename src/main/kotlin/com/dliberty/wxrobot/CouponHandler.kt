package com.dliberty.wxrobot

import cn.fuser.tool.net.Log
import cn.fuser.tool.net.NetLoader
import cn.fuser.vx.wxbot.JSONRespParser
import cn.fuser.vx.wxbot.Message
import cn.fuser.vx.wxbot.WXBot
import com.alibaba.fastjson.JSON

class CouponHandler(private val bot: WXBot) : WXBot.MessageCallback {
    override fun onMessage(m: Message) {
        if (m.msgType != 1) return
        val content = msgContent(m)
        Log.info("receive message %s : %s", m.fromUserName, content)
        if (!content.startsWith("找") || content.length < 2) return
        try {
            val keyword = content.substring(1).trim()
            val couponURL = makeCouponURL(keyword)
            Log.info("search coupon %s %s", keyword, couponURL)
            bot.sendText(m.fromUserName, Config.findCouponReply.format(keyword, couponURL))
        } catch (e: Exception) {
            Log.warn("failed to query coupon", e)
        }
    }

    private fun msgContent(msg: Message): String {
        var c = msg.content
        if (msg.fromUserName.startsWith("@@") || msg.tousername.startsWith("@@"))
            c = c.substringAfter(":<br/>")
        return c
    }

    private fun makeCouponURL(keyword: String): String {
        val resp = shortenURL(keyword)
        if (resp.errNo != 0) throw Exception("failed to generate url")
        val sb = StringBuffer(Config.shortenBase)
        sb.append("/")
        sb.append(resp.data)
        return sb.toString()
    }

    private fun shortenURL(keyword: String): ShortenResp {
        return NetLoader.loadJSON(ShortURLRequest(keyword), JSONRespParser { JSON.parseObject(it, ShortenResp::class.java) })
    }
}