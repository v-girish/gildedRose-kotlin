package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateValueForBackstagePasses(items[i])
            updateValueForAgedBrie(items[i])

            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                degradeQuality(items[i])
            }

            items[i].sellIn = newSellInValueFor(items[i])

            if (items[i].sellIn < 0) {
                updateValueForBackstagePasses(items[i])
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        degradeQuality(items[i])
                    }
                } else {
                    incrementQuality(items[i])
                }
            }
        }
    }

    private fun updateValueForAgedBrie(item: Item) {
        if (item.name == "Aged Brie") {
            incrementQuality(item)
        }
    }

    private fun updateValueForBackstagePasses(item: Item) {
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            incrementQuality(item)

            if (item.sellIn < 11) {
                incrementQuality(item)
            }

            if (item.sellIn < 6) {
                incrementQuality(item)
            }

            if (item.sellIn < 0) {
                item.quality = 0
            }
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

