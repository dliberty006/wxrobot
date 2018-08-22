package com.dliberty.wxrobot

import cn.fuser.tool.net.QRPrinter
import cn.fuser.vx.wxbot.AuthValidator
import cn.fuser.vx.wxbot.WXBot
import java.util.*

fun main(args: Array<String>) {
    val timer = Timer()
    val auth = AuthValidator { QRPrinter(it).print(System.err) }.validate()
    val wxBot = WXBot(auth)
    wxBot.heartbeat()
    timer.schedule(ADTask(wxBot), Config.taskWait * 1000.toLong(), Config.taskTimer * 1000)
}