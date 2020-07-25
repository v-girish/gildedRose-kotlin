package com.gildedrose


class SulfrusItem(sellIn: Int, quality: Int): Item(NAME, sellIn, quality) {

    override fun updateSellInAndQuality() {
        //Do Nothing
    }

    companion object {
        const val NAME = "Sulfuras, Hand of Ragnaros"
    }
}