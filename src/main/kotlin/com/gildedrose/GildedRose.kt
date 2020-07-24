package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateValueForBackstagePasses(items[i])
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                items[i].quality = degradedQualityFor(items[i])
            } else {
                items[i].quality = incrementedQualityFor(items[i])
            }

            items[i].sellIn = newSellInValueFor(items[i])

            if (items[i].sellIn < 0) {
                updateValueForBackstagePasses(items[i])
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        items[i].quality = degradedQualityFor(items[i])
                    }
                } else {
                    items[i].quality = incrementedQualityFor(items[i])
                }
            }
        }
    }

    private fun updateValueForBackstagePasses(item: Item) {
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            if (item.sellIn < 11) {
                item.quality = incrementedQualityFor(item)
            }

            if (item.sellIn < 6) {
                item.quality = incrementedQualityFor(item)
            }

            if (item.sellIn < 0) {
                item.quality = 0
            }
        }
    }

    private fun incrementedQualityFor(an_item: Item): Int {
        if (an_item.quality < 50) {
            return an_item.quality + 1
        }
        return an_item.quality
    }

    private fun degradedQualityFor(an_item: Item): Int {
        if (an_item.quality > 0) {
            if (an_item.name != "Sulfuras, Hand of Ragnaros") {
                return an_item.quality - 1
            }
        }
        return an_item.quality
    }

    private fun newSellInValueFor(an_item: Item): Int {
        if (an_item.name != "Sulfuras, Hand of Ragnaros") {
            return an_item.sellIn - 1
        }
        return an_item.sellIn
    }

}

