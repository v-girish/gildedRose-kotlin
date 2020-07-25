package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val anItem = items[i]

            val itemBy = getItemOf(anItem.name, anItem.sellIn, anItem.quality)
            itemBy.updateSellInAndQuality()

            anItem.sellIn = itemBy.sellIn
            anItem.quality = itemBy.quality
        }
    }

    private fun getItemOf(name: String, sellIn: Int, quality: Int): Item {
        return when(name) {
            "Aged Brie" -> AgedBrieItem(sellIn, quality)
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePassesItem(sellIn, quality)
            "Sulfuras, Hand of Ragnaros" -> SulfrusItem(sellIn, quality)
            else -> NormalItem(sellIn, quality)
        }
    }
}

