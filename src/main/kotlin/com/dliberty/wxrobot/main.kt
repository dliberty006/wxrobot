package com.dliberty.wxrobot

import cn.fuser.tool.net.QRPrinter
import cn.fuser.vx.wxbot.AuthValidator
import cn.fuser.vx.wxbot.WXBot

fun main(args: Array<String>) {
    val auth = AuthValidator { QRPrinter(it).print(System.err) }.validate()
    val wxBot = WXBot(auth)
    wxBot.heartbeat()
    wxBot.registerHandler(CouponHandler(wxBot))
}
