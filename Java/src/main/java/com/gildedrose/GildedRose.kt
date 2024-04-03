package com.gildedrose

class GildedRose(@JvmField var items: List<Item>) {
    fun updateQuality() {
        for (item in items) {
            item.update()
        }
    }
}

