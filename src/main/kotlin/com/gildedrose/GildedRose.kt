package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                items[i].quality = degradedQualityFor(items[i])
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = incrementedQuality(i)

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            items[i].quality = incrementedQuality(i)
                        }

                        if (items[i].sellIn < 6) {
                            items[i].quality = incrementedQuality(i)
                        }
                    }
                }
            }

            items[i].sellIn = newSellInValueFor(items[i])

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        items[i].quality = degradedQualityFor(items[i])
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    items[i].quality = incrementedQuality(i)
                }
            }
        }
    }

    private fun incrementedQuality(i: Int): Int {
        if (items[i].quality < 50) {
            return items[i].quality + 1
        }
        return items[i].quality
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

