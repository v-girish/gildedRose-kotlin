package com.gildedrose


class BackstagePassesItem(sellIn: Int, quality: Int): Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {

    fun updateSellInAndQuality() {
        this.sellIn -=  1

        when {
            this.sellIn >= 10 -> this.quality += 1
            this.sellIn in 5..9 -> this.quality += 2
            this.sellIn in 0..4 -> this.quality += 3
            this.sellIn < 0 -> this.quality = 0
        }

        if (this.quality > 50) {
            this.quality =  50
        }
    }
}