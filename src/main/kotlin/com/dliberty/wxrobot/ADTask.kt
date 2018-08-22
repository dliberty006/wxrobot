package com.dliberty.wxrobot

import cn.fuser.tool.net.Log
import cn.fuser.tool.net.NetError
import cn.fuser.tool.net.NetLoader
import cn.fuser.tool.net.ResponseParser
import cn.fuser.vx.wxbot.WXBot
import com.alibaba.fastjson.JSON
import com.dliberty.liberty.entity.CouponRet
import com.dliberty.liberty.entity.TbkCoupon
import java.io.File
import java.util.*

class ADTask(private val wxBot: WXBot) : TimerTask() {
    private val users = wxBot.contact().list.filter { it.userName.startsWith("@@") }
    private val couponParser = JSONParser({ JSON.parseObject(it, CouponRet::class.java) })

    override fun run() {
        try {
            if (wxBot.shutDown) {
                this.cancel()
                return
            }
            val gc = getCoupon()
            if (gc.code != 0) {
                Log.warn("get coupon error %s", gc.code)
            }
            val msg = renderMessage(gc.coupon)
            val img = downloadImage(gc.coupon.imgUrl)
            users.forEach({
                Log.info("send msg %s %s", it.userName, msg)
                wxBot.sendImg(it.userName, img)
                this.sleep(Config.msgDelay)
                wxBot.sendText(it.userName, msg)
                this.sleep(Config.msgDelay)
            })
        } catch (e: Exception) {
            Log.warn("failed to push message", e)
        }
    }

    private fun sleep(s: Int) = Thread.sleep((s * 1000).toLong())


    private fun downloadImage(url: String): File {
        val path = request(url, ImageParser.instance)
        val f = File(path)
        if (!f.exists()) throw NetError("download image error %s".format(path))
        return f
    }

    private fun renderMessage(tc: TbkCoupon): String = Config.msgTpl.format(tc.title, tc.zkFinalPrice, tc.zkFinalPrice - tc.couponMoney, tc.couponTpwd)
    private fun getCoupon(): CouponRet = request(Config.couponURL, couponParser)
    private fun <T> request(url: String, parser: ResponseParser<T>) = NetLoader.load(BaseRequest(url), HttpRequestParser(), parser)
}