package com.gildedrose

import com.gildedrose.ItemType.*

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            typeOf(item).update(item)
        }
    }
}

private fun degrade(itemType: ItemType, item: Item) {
    when (itemType) {
        BRIE -> {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
        }

        PASS -> {
            if (item.quality < 50) {
                item.quality = item.quality + 1

                if (item.sellIn < 10) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
                if (item.sellIn < 5) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
            if (item.sellIn < 0) {
                item.quality = item.quality - item.quality
            }
        }


        SULFURAS -> {
        }

        OTHER -> {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }
        }
    }
}

private fun age(itemType: ItemType, item: Item) {
    when (itemType) {
        SULFURAS -> {
        }

        else -> item.sellIn = item.sellIn - 1
    }
}

enum class ItemType {
    SULFURAS, PASS, BRIE, OTHER;

    fun update(item: Item) {
        age(this, item)
        degrade(this, item)
    }
}

fun typeOf(item: Item): ItemType = when (item.name) {
    "Sulfuras, Hand of Ragnaros" -> SULFURAS
    "Backstage passes to a TAFKAL80ETC concert" -> PASS
    "Aged Brie" -> BRIE
    else -> OTHER
}
