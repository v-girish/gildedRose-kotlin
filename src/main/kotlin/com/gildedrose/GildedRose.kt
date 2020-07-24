package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateSellInValueFor(items[i])

            updateValueForBackstagePasses(items[i])
            updateValueForAgedBrie(items[i])
            updateValueForNormalItem(items[i])
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

    private fun incrementQualityOf(anItem: Item, incrementBy: Int) {
        anItem.quality =  anItem.quality + incrementBy
        if (anItem.quality > 50) {
            anItem.quality =  50
        }
    }

    private fun updateValueForNormalItem(item: Item) {
        if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert" &&
            item.name != "Sulfuras, Hand of Ragnaros"
        ) {
            when {
                item.sellIn >= 0 -> degradeQualityOf(item, 1)
                else -> degradeQualityOf(item, 2)
            }
        }
    }

    private fun degradeQualityOf(an_item: Item, decrementBy: Int) {
        an_item.quality = an_item.quality - decrementBy
        if (an_item.quality < 0) {
            an_item.quality = 0
        }
    }

    private fun updateSellInValueFor(an_item: Item) {
        if (an_item.name != "Sulfuras, Hand of Ragnaros") {
            an_item.sellIn = an_item.sellIn - 1
        }
    }

}

