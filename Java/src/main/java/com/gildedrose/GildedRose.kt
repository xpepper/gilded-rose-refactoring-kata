package com.gildedrose

class GildedRose(@JvmField var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) item.update()
    }
}

