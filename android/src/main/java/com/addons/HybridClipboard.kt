package com.addons

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.ClipboardManager.OnPrimaryClipChangedListener
import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import android.util.Base64
import com.facebook.react.bridge.ReactApplicationContext
import com.margelo.nitro.NitroModules
import com.margelo.nitro.addons.HybridClipboardSpec
import java.io.ByteArrayOutputStream
import java.io.IOException


class HybridClipboard : HybridClipboardSpec() {

    companion object {
        const val MIMETYPE_JPEG: String = "image/jpeg"

        const val MIMETYPE_JPG: String = "image/jpg"

        const val MIMETYPE_PNG: String = "image/png"

        const val MIMETYPE_WEBP: String = "image/webp"

        const val MIMETYPE_HEIC: String = "image/heic"

        const val MIMETYPE_HEIF: String = "image/heif"
    }

    val reactContext: ReactApplicationContext?
        get() = NitroModules.applicationContext

    fun getClipboardService(): ClipboardManager {
        return NitroModules.applicationContext?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    override fun getString(): String {
        try {
            val clipboard = getClipboardService()
            val clipData = clipboard.primaryClip
            if (clipData != null && clipData.itemCount >= 1) {
                val firstItem = clipData.getItemAt(0)
                return "" + firstItem.text
            } else {
                return ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    override fun getStrings(): Array<String> {
        throw Exception("getStrings is not supported on Android")
    }

    override fun getImagePNG(): String {
        throw Exception("getImagePNG is not supported on Android")
    }

    override fun getImageJPG(): String {
        throw Exception("getImageJPG is not supported on Android")
    }

    override fun setImage(content: String) {
        throw Exception("setImage is not supported on Android")
    }

    override fun getImage(): String {
        val clipboardManager = getClipboardService()
        if (!(clipboardManager.hasPrimaryClip())) {
            return ""
        } else if (clipboardManager.primaryClipDescription!!
                .hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
        ) {
            return ""
        } else {
            val clipData = clipboardManager.primaryClip
            if (clipData != null) {
                val item = clipData.getItemAt(0)
                val pasteUri = item.uri
                if (pasteUri != null) {
                    val cr: ContentResolver = reactContext!!.contentResolver
                    val mimeType = cr.getType(pasteUri)
                    if (mimeType != null) {
                        try {
                            val bitmap = MediaStore.Images.Media.getBitmap(cr, pasteUri)
                            val outputStream = ByteArrayOutputStream()
                            when (mimeType) {
                                MIMETYPE_JPEG, MIMETYPE_JPG -> bitmap.compress(
                                    Bitmap.CompressFormat.JPEG,
                                    100,
                                    outputStream
                                )

                                MIMETYPE_PNG, MIMETYPE_HEIC, MIMETYPE_HEIF -> bitmap.compress(
                                    Bitmap.CompressFormat.PNG,
                                    100,
                                    outputStream
                                )

                                MIMETYPE_WEBP -> {
                                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
                                        bitmap.compress(
                                            Bitmap.CompressFormat.WEBP_LOSSLESS,
                                            100,
                                            outputStream
                                        )

                                    } else
                                        bitmap.compress(
                                            Bitmap.CompressFormat.WEBP,
                                            100,
                                            outputStream
                                        )
                                }

                                else -> return ""
                            }
                            val byteArray = outputStream.toByteArray()
                            val encodedString: String? =
                                Base64.encodeToString(byteArray, Base64.DEFAULT)
                            return "data:$mimeType;base64,$encodedString"
                        } catch (e: IOException) {
                            e.printStackTrace()
                            throw e
                        }
                    }
                }
            }
            return ""
        }
    }

    override fun setString(content: String) {
        try {
            val clipdata = ClipData.newPlainText(null, content)
            val clipboard = getClipboardService()
            clipboard.setPrimaryClip(clipdata)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun setStrings(content: Array<String>) {
        throw Exception("setStrings is not supported on Android")
    }

    override fun hasString(): Boolean {
        val clipboard = getClipboardService()
        val clipData = clipboard.primaryClip
        return clipData != null && clipData.itemCount >= 1
    }

    override fun hasImage(): Boolean {
        throw Exception("hasImage is not supported on Android")
    }

    override fun hasURL(): Boolean {
        throw Exception("hasURL is not supported on Android")
    }

    override fun hasNumber(): Boolean {
        throw Exception("hasNumber is not supported on Android")
    }

    override fun hasWebURL(): Boolean {
        throw Exception("hasWebURL is not supported on Android")
    }

    var listener: OnPrimaryClipChangedListener? = null
    var listeners: ArrayList<(() -> Unit)> = arrayListOf()

    override fun onClipboardChanged(callback: () -> Unit) {
        try {
            if (listeners.isNotEmpty()) {
                listeners.add { callback }
                return
            }
            val clipboard = getClipboardService()
            listener = OnPrimaryClipChangedListener {
                listeners.forEach { fn -> fn() }
            }
            clipboard.addPrimaryClipChangedListener(listener)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun removeAllListeners() {
        val clipboard = getClipboardService()
        listeners.clear()
        if (listener != null)
            clipboard.removePrimaryClipChangedListener(listener)
    }


}
