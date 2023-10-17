package com.gildedrose

class GildedRose(@JvmField var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) update(item)
    }
}

private fun update(item: Item) {
    val name = item.name
    if (name != "Aged Brie"
        && name != "Backstage passes to a TAFKAL80ETC concert") {
        if (item.quality > 0) {
            if (name != "Sulfuras, Hand of Ragnaros") {
                item.quality = item.quality - 1
            }
        }
    } else {
        if (item.quality < 50) {
            item.quality = item.quality + 1

            if (name == "Backstage passes to a TAFKAL80ETC concert") {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
        }
    }

    if (name != "Sulfuras, Hand of Ragnaros") {
        item.sellIn = item.sellIn - 1
    }

    if (item.sellIn < 0) {
        if (name != "Aged Brie") {
            if (name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    if (name != "Sulfuras, Hand of Ragnaros") {
                        item.quality = item.quality - 1
                    }
                }
            } else {
                item.quality = item.quality - item.quality
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }
}
