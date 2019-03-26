package io.github.data

import io.github.domain.Item

class ItemsRepository(private val itemPersistenceSource : ItemPersistatenceSource) {

    fun fetchItem(query:String):List<Item>{
        return itemPersistenceSource.queryItem(query)
    }

    fun addItem(name:String, itemType:Int){
        return itemPersistenceSource.addItem(name, itemType)
    }
}