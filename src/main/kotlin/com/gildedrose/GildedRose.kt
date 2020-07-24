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
        when {
            item.sellIn > 0 -> incrementQuality(1, item)
            else -> incrementQuality(2, item)
        }
    }

    private fun updateQualityForBackstagePasses(item: Item) {
        when {
            item.sellIn >= 10 -> incrementQuality(1, item)
            item.sellIn in 5..9 -> incrementQuality(2, item)
            item.sellIn in 0..4 -> incrementQuality(3, item)
            item.sellIn < 0 -> item.quality = 0
        }
    }

    private fun updateQualityForSulfuras(item: Item) {
        item.quality = item.quality
    }

    private fun updateQualityForNormalItem(item: Item) {
        when {
            item.sellIn >= 0 -> decrementQuality(1, item)
            else -> decrementQuality(2, item)
        }
    }

    private fun incrementQuality(by: Int, ofItem: Item) {
        ofItem.quality =  ofItem.quality + by
        if (ofItem.quality > 50) {
            ofItem.quality =  50
        }
    }

    private fun decrementQuality(by: Int, ofItem: Item) {
        ofItem.quality = ofItem.quality - by
        if (ofItem.quality < 0) {
            ofItem.quality = 0
        }
    }

    private fun updateSellInValueFor(anItem: Item) {
        if (anItem.name != "Sulfuras, Hand of Ragnaros") {
            anItem.sellIn = anItem.sellIn - 1
        }
    }

}

