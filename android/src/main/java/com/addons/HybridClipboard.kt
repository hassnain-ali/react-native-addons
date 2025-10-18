package com.addons

import com.margelo.nitro.addons.HybridClipboardSpec
import com.margelo.nitro.core.Promise

class HybridClipboard: HybridClipboardSpec() {
    override fun getString(): Promise<String> {
        TODO("Not yet implemented")
    }

    override fun getStrings(): Promise<Array<String>> {
        TODO("Not yet implemented")
    }

    override fun getImagePNG(): Promise<String> {
        TODO("Not yet implemented")
    }

    override fun getImageJPG(): Promise<String> {
        TODO("Not yet implemented")
    }

    override fun setImage(content: String) {
        TODO("Not yet implemented")
    }

    override fun getImage(): Promise<String> {
        TODO("Not yet implemented")
    }

    override fun setString(content: String) {
        TODO("Not yet implemented")
    }

    override fun setStrings(content: Array<String>) {
        TODO("Not yet implemented")
    }

    override fun hasString(): Promise<Boolean> {
        TODO("Not yet implemented")
    }

    override fun hasImage(): Promise<Boolean> {
        TODO("Not yet implemented")
    }

    override fun hasURL(): Promise<Boolean>? {
        TODO("Not yet implemented")
    }

    override fun hasNumber(): Promise<Boolean>? {
        TODO("Not yet implemented")
    }

    override fun hasWebURL(): Promise<Boolean>? {
        TODO("Not yet implemented")
    }

    override fun onClipboardChanged(callback: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun removeAllListeners() {
        TODO("Not yet implemented")
    }

}
