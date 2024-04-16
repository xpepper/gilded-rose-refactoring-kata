package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.updated(): List<Item> = this.map { it.updated() }
val GildedRose.items: List<Item>
    get() = this
