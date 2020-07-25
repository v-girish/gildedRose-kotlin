package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val anItem = items[i]

            when(anItem.name) {
                "Aged Brie" -> updateQualityForAgedBrie(anItem)
                "Backstage passes to a TAFKAL80ETC concert" -> updateQualityForBackstagePasses(anItem)
                "Sulfuras, Hand of Ragnaros" -> updateQualityForSulfuras(anItem)
                else -> updateQualityForNormalItem(anItem)
            }
        }
    }

    private fun updateQualityForAgedBrie(item: Item) {
        val agedBrieItem = AgedBrieItem(item.sellIn, item.quality)
        agedBrieItem.updateSellInAndQuality()

        item.sellIn = agedBrieItem.sellIn
        item.quality = agedBrieItem.quality
    }

    private fun updateQualityForBackstagePasses(item: Item) {
        val backstagePassesItem = BackstagePassesItem(item.sellIn, item.quality)
        backstagePassesItem.updateSellInAndQuality()

        item.sellIn = backstagePassesItem.sellIn
        item.quality = backstagePassesItem.quality
    }

    private fun updateQualityForSulfuras(item: Item) {
        val sulfrusItem = SulfrusItem(item.sellIn, item.quality)
        sulfrusItem.updateSellInAndQuality()

        item.sellIn = sulfrusItem.sellIn
        item.quality = sulfrusItem.quality
    }

    private fun updateQualityForNormalItem(item: Item) {
        val normalItem = NormalItem(item.sellIn, item.quality)
        normalItem.updateSellInAndQuality()

        item.sellIn = normalItem.sellIn
        item.quality = normalItem.quality
    }

    private fun decrementQuality(ofItem: Item, by: Int) {
        ofItem.quality = ofItem.quality - by
        if (ofItem.quality < 0) {
            ofItem.quality = 0
        }
    }

}

