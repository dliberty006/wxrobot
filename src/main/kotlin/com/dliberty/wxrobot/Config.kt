package com.dliberty.wxrobot

import cn.fuser.util.Property

object Config {
    private val prop = Property.create("wxrobot.properties")
    val couponURL: String by prop.string("coupon.url")
    val tmpDir: String by prop.string("tmp.dir")
    val msgTpl: String by prop.string("message.tpl")
    val msgDelay: Int by prop.int("task.wait", 3)
    val taskWait: Int by prop.int("task.wait", 3)
    val taskTimer: Long by prop.long("task.timer", 60)
}