package com.dliberty.wxrobot

import cn.fuser.tool.net.NetError
import cn.fuser.tool.net.RequestParser
import cn.fuser.tool.net.ResponseParser
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.apache.commons.io.FilenameUtils
import java.io.FileOutputStream
import java.net.URL
import java.nio.file.Paths
import java.util.*

class HttpRequestParser<in T : BaseRequest> : RequestParser<T> {
    override fun parse(o: T): Request = when (o.method) {
        HttpMethod.GET -> parseGET(o)
        HttpMethod.POST -> parsePOST(o)
    }

    private fun parseGET(o: T): Request = Request.Builder().url(o.url).get().build()

    private fun parsePOST(o: T): Request {
        val body = RequestBody.create(null, ByteArray(0))
        return Request.Builder().url(o.url).post(body).build()
    }
}

class ImageParser(saveDir: String) : ResponseParser<String> {
    private val tmpDir = Paths.get(saveDir)
    private val readSize = 4096

    companion object {
        val instance = ImageParser(Config.tmpDir)
    }

    override fun parse(resp: Response): String {
        val input = resp.body()?.byteStream() ?: throw NetError("error response %s".format(resp.request().url()))
        val dir = tmpDir.toFile()
        if (!dir.exists()) dir.mkdirs()
        val path = tmpDir.resolve(rangeName(resp.request().url().url()))
        val output = FileOutputStream(path.toString())
        val buf = ByteArray(readSize)
        var len: Int
        while (true) {
            len = input.read(buf)
            if (len < 0) {
                break
            }
            output.write(buf, 0, len)
        }
        return path.toString()
    }

    private fun rangeName(url: URL): String {
        var v = (System.currentTimeMillis() shl 4) or Random().nextLong()
        if (v < 1) v = -v
        val ext = FilenameUtils.getExtension(url.path)
        return "%d.%s".format(v, ext)
    }
}

class JSONParser<out T>(private val handler: (String) -> T) : ResponseParser<T> {
    override fun parse(resp: Response): T {
        val text = resp.body()?.string() ?: throw NetError("empty Response %s".format(resp.request().url()))
        return handler.invoke(text)
    }
}
