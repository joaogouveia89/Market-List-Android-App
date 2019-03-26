package io.github.data

import io.github.domain.Item

interface ItemPersistatenceSource {
    fun queryItem(name:String):List<Item>
    fun addItem(name:String, itemType:Int)
}
