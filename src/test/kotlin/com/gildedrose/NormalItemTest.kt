package com.gildedrose

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class NormalItemTest {

    @Test
    fun `should degrade the quality by 1 given sell by date is in 20 days`() {
        val normalItem = NormalItem(20, 25)

        normalItem.updateSellInAndQuality()

        normalItem.quality shouldBe 24
    }

    @Test
    fun `should degrade the quality by 2 given sell by date is 0 days ago`() {
        val normalItem = NormalItem(0, 25)

        normalItem.updateSellInAndQuality()

        normalItem.quality shouldBe 23
    }

    @Test
    fun `should degrade the quality by 2 given sell by date was 2 days ago`() {
        val normalItem = NormalItem(-2, 25)

        normalItem.updateSellInAndQuality()

        normalItem.quality shouldBe 23
    }

    @Test
    fun `should not degrade the quality given quality is already zero`() {
        val normalItem = NormalItem(20, 0)

        normalItem.updateSellInAndQuality()

        normalItem.quality shouldBe 0
    }

    @Test
    fun `should decrease the sellIn date by 1`() {
        val normalItem = NormalItem(20, 25)

        normalItem.updateSellInAndQuality()

        normalItem.sellIn shouldBe 19
    }

}