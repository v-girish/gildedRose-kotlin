package com.gildedrose


class AgedBrieItem(sellIn: Int, quality: Int): Item("Aged Brie", sellIn, quality) {

    override fun updateSellInAndQuality() {
        this.sellIn -=  1
        when {
            this.sellIn > 0 -> this.quality += 1
            else -> this.quality += 2
        }

        if (this.quality > 50) {
            this.quality =  50
        }
    }

}