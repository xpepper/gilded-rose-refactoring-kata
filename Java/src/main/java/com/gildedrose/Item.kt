package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString() = "${this.name}, ${this.sellIn}, ${this.quality}"
}

open class BaseItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    fun update() {
        age()
        degrade()
        saturate()
    }

    protected open fun age() {
        sellIn = sellIn - 1
    }

    protected open fun degrade() {
        if (quality > 0) {
            quality = quality - 1
        }
        if (sellIn < 0) {
            if (quality > 0) {
                quality = quality - 1
            }
        }
    }

    protected open fun saturate() {
        if (quality < 0) quality = 0
        if (quality > 50) quality = 50
    }
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun degrade() {
        if (quality < 50) {
            quality = quality + 1
        }
        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1
            }
        }
    }
}

class BackstagePass(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun degrade() {
        if (quality < 50) {
            quality = quality + 1

            if (sellIn < 10) {
                if (quality < 50) {
                    quality = quality + 1
                }
            }

            if (sellIn < 5) {
                if (quality < 50) {
                    quality = quality + 1
                }
            }
        }
        if (sellIn < 0) {
            quality = 0
        }
    }

}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun age() {}
    override fun degrade() {}
    override fun saturate() {}
}
