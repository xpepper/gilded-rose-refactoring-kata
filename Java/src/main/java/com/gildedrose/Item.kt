package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString() = "${this.name}, ${this.sellIn}, ${this.quality}"
}

object Aging {
    val standard: () -> Int = { 1 }
    val none: () -> Int = { 0 }
}

object Degradation {
    val standard: (Int, Int) -> Int = fun(sellIn: Int, quality: Int): Int = when {
        sellIn < 0 -> 2
        else -> 1
    }
    val none: (Int, Int) -> Int = { _, _ -> 0 }
}

object Saturation {
    val standard: (Int) -> Int = fun(quality: Int) = when {
        quality < 0 -> 0
        quality > 50 -> 50
        else -> quality
    }
    val none: (Int) -> Int = { it }
}

class BaseItem(
    name: String,
    sellIn: Int,
    quality: Int,
    private val aging: () -> Int = Aging.standard,
    private val degradation: (Int, Int) -> Int = Degradation.standard,
    private val saturation: (Int) -> Int = Saturation.standard
) : Item(name, sellIn, quality) {
    fun update() {
        sellIn = sellIn - aging()
        quality = saturation(quality - degradation(sellIn, quality))
    }

}

fun Brie(name: String, sellIn: Int, quality: Int) = BaseItem(
    name,
    sellIn,
    quality,
    degradation = { currentSellIn, _ ->
        when {
            currentSellIn < 0 -> -2
            else -> -1
        }
    }
)

fun BackstagePass(name: String, sellIn: Int, quality: Int) = BaseItem(
    name,
    sellIn,
    quality,
    degradation = { currentSellIn, currentQuality ->
        when {
            currentSellIn < 0 -> currentQuality
            currentSellIn < 5 -> -3
            currentSellIn < 10 -> -2
            else -> -1
        }
    }
)

fun Sulfuras(name: String, sellIn: Int, quality: Int) = BaseItem(
    name,
    sellIn,
    quality,
    aging = Aging.none,
    degradation = Degradation.none,
    saturation = Saturation.none
)

fun Conjured(name: String, sellIn: Int, quality: Int) = BaseItem(
    name,
    sellIn,
    quality,
    degradation = { sellIn, quality -> Degradation.standard(sellIn, quality) * 2 }
)
