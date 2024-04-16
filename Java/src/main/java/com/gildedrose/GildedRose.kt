package com.gildedrose

import com.gildedrose.ItemType.*

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            update(item)
        }
    }
}

private fun update(item: Item) {
    val itemType = typeOf(item)
    when (itemType) {
        PASS -> {
            if (item.quality < 50) {
                item.quality = item.quality + 1

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

        BRIE -> {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }

        else -> {
            if (item.quality > 0) {
                when (itemType) {
                    SULFURAS -> {
                    }

                    else -> {
                        item.quality = item.quality - 1
                    }
                }
            }
        }
    }

    when (itemType) {
        SULFURAS -> {
        }

        else -> {
            item.sellIn = item.sellIn - 1
        }
    }

    if (item.sellIn < 0) {
        when (itemType) {
            BRIE -> {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }

            else -> {
                when (itemType) {
                    PASS -> {
                        item.quality = item.quality - item.quality
                    }

                    else -> {
                        if (item.quality > 0) {
                            if (itemType == SULFURAS) return
                            item.quality = item.quality - 1
                        }
                    }
                }
            }
        }
    }
}

enum class ItemType {
    SULFURAS, PASS, BRIE, OTHER
}

fun typeOf(item: Item): ItemType = when (item.name) {
    "Sulfuras, Hand of Ragnaros" -> SULFURAS
    "Backstage passes to a TAFKAL80ETC concert" -> PASS
    "Aged Brie" -> BRIE
    else -> OTHER
}
