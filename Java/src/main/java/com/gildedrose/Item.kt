package com.gildedrose

class Item(
    val name: String,
    var sellIn: Int = 0,
    var quality: Int = 0
) {

    override fun toString() = "${this.name}, ${this.sellIn}, ${this.quality}"
}

fun Item.update() {
    val name = name
    if (name != "Aged Brie"
        && name != "Backstage passes to a TAFKAL80ETC concert") {
        if (quality > 0) {
            if (name != "Sulfuras, Hand of Ragnaros") {
                quality = quality - 1
            }
        }
    } else {
        if (quality < 50) {
            quality = quality + 1

            if (name == "Backstage passes to a TAFKAL80ETC concert") {
                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1
                    }
                }
            }
        }
    }

    if (name != "Sulfuras, Hand of Ragnaros") {
        sellIn = sellIn - 1
    }

    if (sellIn < 0) {
        if (name != "Aged Brie") {
            if (name != "Backstage passes to a TAFKAL80ETC concert") {
                if (quality > 0) {
                    if (name != "Sulfuras, Hand of Ragnaros") {
                        quality = quality - 1
                    }
                }
            } else {
                quality = quality - quality
            }
        } else {
            if (quality < 50) {
                quality = quality + 1
            }
        }
    }
}
