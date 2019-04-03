package io.github.data

import io.github.domain.Item
import io.reactivex.Observable

interface ItemPersistatenceSource {
    fun queryItem(name:String): Observable<List<Item>>
    fun addItem(name:String, itemType:Int)
}
