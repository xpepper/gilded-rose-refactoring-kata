package com.gildedrose

class Item(name: String?, sellIn: Int, quality: Int) {
    var name: String? = null
    var sellIn: Int = 0
    var quality: Int = 0

    init {
        this.name = name
        this.sellIn = sellIn
        this.quality = quality
    }

    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}
