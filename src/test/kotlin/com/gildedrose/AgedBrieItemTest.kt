package com.gildedrose

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class AgedBrieItemTest {

    @Test
    fun `should increase the quality by 1 when sell in date is 20 days away`() {
        val agedBrie = AgedBrieItem(20, 25)

        agedBrie.updateSellInAndQuality()

        agedBrie.quality shouldBe 26
    }

    @Test
    fun `should increase the quality by 2 when sellIn date has passed`() {
        val agedBrie = AgedBrieItem(-1, 25)

        agedBrie.updateSellInAndQuality()

        agedBrie.quality shouldBe 27
    }

    @Test
    fun `should increase the quality upto maximum of 50 when sellIn date has passed`() {
        val agedBrie = AgedBrieItem(-1, 49)

        agedBrie.updateSellInAndQuality()

        agedBrie.quality shouldBe 50
    }

    @Test
    fun `should increase the quality by 2 when sellIn date is 0 days away`() {
        val agedBrie = AgedBrieItem(0, 25)

        agedBrie.updateSellInAndQuality()

        agedBrie.quality shouldBe 27
    }

    @Test
    fun `should not increase the quality when quality is equal to 50`() {
        val agedBrie = AgedBrieItem(20, 50)

        agedBrie.updateSellInAndQuality()

        agedBrie.quality shouldBe 50
    }

    @Test
    fun `should decrease the sellIn date by 1`() {
        val agedBrie = AgedBrieItem(20, 50)

        agedBrie.updateSellInAndQuality()

        agedBrie.sellIn shouldBe 19
    }

}