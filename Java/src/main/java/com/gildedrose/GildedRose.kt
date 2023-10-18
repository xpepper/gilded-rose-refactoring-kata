package com.gildedrose

class GildedRose(@JvmField var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            if (item is BaseItem)
                item.update()
            else
                error("item is not a BaseItem")
        }
    }
}

