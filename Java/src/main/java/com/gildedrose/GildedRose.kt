package com.gildedrose

typealias GildedRose = List<Item>

fun GildedRose.updated(): List<Item> = this.map { it.updated() }
