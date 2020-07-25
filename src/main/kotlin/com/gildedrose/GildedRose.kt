package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val anItem = items[i]

            updateSellInValueFor(anItem)

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
        when {
            item.sellIn >= 10 -> incrementQuality(ofItem = item, by = 1)
            item.sellIn in 5..9 -> incrementQuality(ofItem = item, by = 2)
            item.sellIn in 0..4 -> incrementQuality(ofItem = item, by = 3)
            item.sellIn < 0 -> item.quality = 0
        }
    }

    private fun updateQualityForSulfuras(item: Item) {
        item.quality = item.quality
    }

    private fun updateQualityForNormalItem(item: Item) {
        when {
            item.sellIn >= 0 -> decrementQuality(ofItem = item, by = 1)
            else -> decrementQuality(ofItem = item, by = 2)
        }
    }

    private fun incrementQuality(ofItem: Item, by: Int) {
        ofItem.quality =  ofItem.quality + by
        if (ofItem.quality > 50) {
            ofItem.quality =  50
        }
    }

    private fun decrementQuality(ofItem: Item, by: Int) {
        ofItem.quality = ofItem.quality - by
        if (ofItem.quality < 0) {
            ofItem.quality = 0
        }
    }

    private fun updateSellInValueFor(anItem: Item) {
        if (anItem.name != "Sulfuras, Hand of Ragnaros" && anItem.name != "Aged Brie") {
            anItem.sellIn = anItem.sellIn - 1
        }
    }

}

