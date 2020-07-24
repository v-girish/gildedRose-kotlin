package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                degradeQuality(items[i])
            }

            items[i].sellIn = newSellInValueFor(items[i])
            updateValueForBackstagePasses(items[i])
            updateValueForAgedBrie(items[i])

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        degradeQuality(items[i])
                    }
                }
            }
        }
    }

    private fun updateValueForAgedBrie(item: Item) {
        if (item.name == "Aged Brie") {
            when {
                item.sellIn > 0 -> incrementQualityOf(item, 1)
                else -> incrementQualityOf(item, 2)
            }
        }
    }

    private fun updateValueForBackstagePasses(item: Item) {
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            when {
                item.sellIn >= 10 -> incrementQualityOf(item, 1)
                item.sellIn in 5..9 -> incrementQualityOf(item, 2)
                item.sellIn in 0..4 -> incrementQualityOf(item, 3)
                item.sellIn < 0 -> item.quality = 0
            }
        }
    }

    private fun incrementQualityOf(an_item: Item, increment_by: Int) {
        if (an_item.quality < 50) {
            an_item.quality =  an_item.quality + increment_by
        }
    }

    private fun incrementQuality(an_item: Item) {
        if (an_item.quality < 50) {
            an_item.quality =  an_item.quality + 1
        }
    }

    private fun degradeQuality(an_item: Item) {
        if (an_item.quality > 0) {
            if (an_item.name != "Sulfuras, Hand of Ragnaros") {
                an_item.quality = an_item.quality - 1
            }
        }
    }

    private fun newSellInValueFor(an_item: Item): Int {
        if (an_item.name != "Sulfuras, Hand of Ragnaros") {
            return an_item.sellIn - 1
        }
        return an_item.sellIn
    }

}

