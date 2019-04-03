package io.github.data

import io.github.domain.Item
import java.util.*
import io.reactivex.Observable

class ItemsRepository(private val itemPersistenceSource : ItemPersistatenceSource) {

    fun fetchItem(query:String):Observable<List<Item>>{
        return itemPersistenceSource.queryItem(query)
    }

    fun addItem(name:String, itemType:Int){
        return itemPersistenceSource.addItem(name, itemType)
    }
}