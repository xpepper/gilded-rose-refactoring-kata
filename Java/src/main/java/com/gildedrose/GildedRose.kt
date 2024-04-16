package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            update(item)
        }
    }
}

private fun update(item: Item) {
    if (isBrie(item) || isPass(item)) {
        if (item.quality < 50) {
            item.quality = item.quality + 1

            if (isPass(item)) {
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
    } else {
        if (item.quality > 0) {
            if (isSulfuras(item)) {
            } else {
                item.quality = item.quality - 1
            }
        }
    }

    if (isSulfuras(item)) {
    } else {
        item.sellIn = item.sellIn - 1
    }

    if (item.sellIn < 0) {
        if (isBrie(item)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        } else {
            if (isPass(item)) {
                item.quality = item.quality - item.quality
            } else {
                if (item.quality > 0) {
                    if (isSulfuras(item)) return
                    item.quality = item.quality - 1
                }
            }
        }
    }
}

private fun isSulfuras(item: Item) = item.name == "Sulfuras, Hand of Ragnaros"

private fun isPass(item: Item) = item.name == "Backstage passes to a TAFKAL80ETC concert"

private fun isBrie(item: Item) = item.name == "Aged Brie"
