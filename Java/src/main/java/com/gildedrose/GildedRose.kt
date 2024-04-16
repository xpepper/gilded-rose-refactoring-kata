package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            typeOf(item).update(item)
        }
    }
}

object SULFURAS : ItemType() {
    override fun ItemType.age(item: Item) {
    }
}

object PASS : ItemType()
object BRIE : ItemType() {
    override fun ItemType.degrade(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }
}

object OTHER : ItemType()

open class ItemType {
    fun update(item: Item) {
        this.age(item)
        this.degrade(item)
    }

    protected open fun ItemType.age(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    protected open fun ItemType.degrade(item: Item) {
        when (this) {
            PASS -> {
                degradePass(item)
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

    private fun degradePass(item: Item) {
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

}

fun typeOf(item: Item): ItemType = when (item.name) {
    "Sulfuras, Hand of Ragnaros" -> SULFURAS
    "Backstage passes to a TAFKAL80ETC concert" -> PASS
    "Aged Brie" -> BRIE
    else -> OTHER
}
