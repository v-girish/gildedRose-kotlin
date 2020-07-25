package com.gildedrose


class NormalItem(sellIn: Int, quality: Int): Item("Aged Brie", sellIn, quality) {

    fun updateSellInAndQuality() {
        this.sellIn -= 1
        when {
            this.sellIn >= 0 -> this.quality -= 1
            else -> this.quality -= 2
        }

        if (this.quality < 0) {
            this.quality =  0
        }
    }

}