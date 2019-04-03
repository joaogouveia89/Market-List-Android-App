package com.example.joaogouveia89.marketlist.item

import com.example.joaogouveia89.marketlist.framework.bases.RetrofitBase
import io.github.data.ItemPersistatenceSource
import io.github.domain.Item
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ItemPersistence : ItemPersistatenceSource {

    private var retrofitBase:RetrofitBase<ItemPersistatenceSource> = RetrofitBase(ItemPersistatenceSource::class.java)

    override fun queryItem(name: String): Observable<List<Item>> {
        return retrofitBase
            .getDataInterfaceInstance()!!
            .queryItem(name)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun addItem(name: String, itemType: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}