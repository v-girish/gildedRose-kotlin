package com.gildedrose

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class BackstagePassesItemTest {

    @Test
    fun `should increase the quality by 1 when sellIn date is more than 10 days away`() {
        val backstagePasses = BackstagePassesItem(11, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 26
    }

    @Test
    fun `should increase the quality by 2 when sellIn date is in exactly 10 days`() {
        val backstagePasses = BackstagePassesItem(10, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 27
    }

    @Test
    fun `should increase the quality by 2 when sellIn date is in less than 10 days but greater than 5 days`() {
        val backstagePasses = BackstagePassesItem(9, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 27
    }

    @Test
    fun `should increase the quality by 3 when sellIn date is in exactly 5 days`() {
        val backstagePasses = BackstagePassesItem(5, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 28
    }

    @Test
    fun `should increase the quality by 3 when sellIn date is less than 5 days away`() {
        val backstagePasses = BackstagePassesItem(4, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 28
    }

    @Test
    fun `should drop the quality to 0 when sellIn date is today`() {
        val backstagePasses = BackstagePassesItem(0, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 0
    }

    @Test
    fun `should drop the quality to 0 when sellIn date has passed`() {
        val backstagePasses = BackstagePassesItem(-1, 25)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.quality shouldBe 0
    }

    @Test
    fun `should decrease the sellIn date by 1`() {
        val backstagePasses = BackstagePassesItem(20, 50)

        backstagePasses.updateSellInAndQuality()

        backstagePasses.sellIn shouldBe 19
    }

}