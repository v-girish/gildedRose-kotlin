package com.gildedrose


class ItemFactory {

    companion object {
        fun getItemWith(name: String, sellIn: Int, quality: Int): Item {
            return when(name) {
                AgedBrieItem.NAME -> AgedBrieItem(sellIn, quality)
                BackstagePassesItem.NAME -> BackstagePassesItem(sellIn, quality)
                SulfrusItem.NAME -> SulfrusItem(sellIn, quality)
                else -> NormalItem(sellIn, quality)
            }
        }
    }


}