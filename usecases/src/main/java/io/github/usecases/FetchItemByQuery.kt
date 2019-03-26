package io.github.usecases

import io.github.data.ItemsRepository
import io.github.domain.Item

class FetchItemByQuery(private val itemsRepository:ItemsRepository,
                       private val query:String) {
    operator fun invoke () : List<Item> = itemsRepository.fetchItem(query)
}