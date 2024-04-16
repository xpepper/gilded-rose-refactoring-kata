package com.gildedrose

class Item(
    val name: String,
    val sellIn: Int,
    val quality: Int,
    private val aging: () -> Int = Aging.standard,
    private val degradation: (Int, Int) -> Int = Degradation.standard,
    private val saturation: (Int) -> Int = Saturation.standard
) {

    fun updated(): Item {
        val sellIn = sellIn - aging()
        val quality = saturation(quality - degradation(sellIn, quality))
        return Item(
            name,
            sellIn = sellIn,
            quality = quality,
            aging = aging,
            degradation = degradation,
            saturation = saturation
        )
    }

    override fun toString() = "${this.name}, ${this.sellIn}, ${this.quality}"
}
