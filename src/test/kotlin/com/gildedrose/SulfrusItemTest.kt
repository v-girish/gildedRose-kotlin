package com.gildedrose

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class SulfrusItemTest {

    @Test
    fun `should not degrade the quality given sell by date is in 20 days`() {
        val sulfuras = SulfrusItem(20, 80)

        sulfuras.updateSellInAndQuality()

        sulfuras.quality shouldBe 80
    }

    @Test
    fun `should not degrade the quality given sell by date was 1 day ago`() {
        val sulfuras = SulfrusItem(-1, 80)

        sulfuras.updateSellInAndQuality()

        sulfuras.quality shouldBe 80
    }

    @Test
    fun `should not decrease the sell in date`() {
        val sulfuras = SulfrusItem(20, 80)

        sulfuras.updateSellInAndQuality()

        sulfuras.sellIn shouldBe 20
    }

}