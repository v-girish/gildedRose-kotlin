package com.gildedrose

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test


class GildedRoseCharacterizationTest {

    @Test
    fun `should not degrade the quality given item is Sulfuras and sell by date is in 20 days`() {
        val sulfuras = Item("Sulfuras, Hand of Ragnaros", 20, 80)
        val gildedRose = GildedRose(arrayOf(sulfuras))

        gildedRose.updateQuality()

        sulfuras.quality shouldBe 80
    }

    @Test
    fun `should not degrade the quality given item is Sulfuras and sell by date was 1 day ago`() {
        val sulfuras = Item("Sulfuras, Hand of Ragnaros", -1, 80)
        val gildedRose = GildedRose(arrayOf(sulfuras))

        gildedRose.updateQuality()

        sulfuras.quality shouldBe 80
    }

    @Test
    fun `should not decrease the sell in date given item is Sulfuras`() {
        val sulfuras = Item("Sulfuras, Hand of Ragnaros", 20, 80)
        val gildedRose = GildedRose(arrayOf(sulfuras))

        gildedRose.updateQuality()

        sulfuras.sellIn shouldBe 20
    }

    @Test
    fun `should degrade the quality by 1 given item is a normal item and sell by date is in 20 days`() {
        val normalItem = Item("Not a special Item", 20, 25)
        val gildedRose = GildedRose(arrayOf(normalItem))

        gildedRose.updateQuality()

        normalItem.quality shouldBe 24
    }

    @Test
    fun `should degrade the quality by 2 given item is a normalItem and sell by date was 2 days ago`() {
        val normalItem = Item("Not a special Item", -2, 25)
        val gildedRose = GildedRose(arrayOf(normalItem))

        gildedRose.updateQuality()

        normalItem.quality shouldBe 23
    }

    @Test
    fun `should not degrade the quality given item is a normalItem and quality is already zero`() {
        val normalItem = Item("Not a special Item", 20, 0)
        val gildedRose = GildedRose(arrayOf(normalItem))

        gildedRose.updateQuality()

        normalItem.quality shouldBe 0
    }

    @Test
    fun `should decrease the sellIn date by 1 given item is a normalItem`() {
        val normalItem = Item("Not a special Item", 20, 25)
        val gildedRose = GildedRose(arrayOf(normalItem))

        gildedRose.updateQuality()

        normalItem.sellIn shouldBe 19
    }


    @Test
    fun `should increase the quality by 1 when item is Aged Brie`() {
        val agedBrie = Item("Aged Brie", 20, 25)
        val gildedRose = GildedRose(arrayOf(agedBrie))

        gildedRose.updateQuality()

        agedBrie.quality shouldBe 26
    }

    @Test
    fun `should increase the quality by 2 when item is Aged Brie and sellIn date has passed`() {
        val agedBrie = Item("Aged Brie", -1, 25)
        val gildedRose = GildedRose(arrayOf(agedBrie))

        gildedRose.updateQuality()

        agedBrie.quality shouldBe 27
    }

    @Test
    fun `should not increase the quality when item is Aged Brie and quality is equal to 50`() {
        val agedBrie = Item("Aged Brie", 20, 50)
        val gildedRose = GildedRose(arrayOf(agedBrie))

        gildedRose.updateQuality()

        agedBrie.quality shouldBe 50
    }

    @Test
    fun `should decrease the sellIn date by 1 given item is Aged Brie`() {
        val agedBrie = Item("Aged Brie", 20, 25)
        val gildedRose = GildedRose(arrayOf(agedBrie))

        gildedRose.updateQuality()

        agedBrie.sellIn shouldBe 19
    }

    @Test
    fun `should increase the quality by 1 when item is Backstage passes and sellIn date is more than 10 days away`() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 11, 25)
        val gildedRose = GildedRose(arrayOf(backstagePasses))

        gildedRose.updateQuality()

        backstagePasses.quality shouldBe 26
    }

    @Test
    fun `should increase the quality by 2 when item is Backstage passes and sellIn date is in less than 10 days but greater than 5 days`() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 9, 25)
        val gildedRose = GildedRose(arrayOf(backstagePasses))

        gildedRose.updateQuality()

        backstagePasses.quality shouldBe 27
    }

    @Test
    fun `should increase the quality by 3 when item is Backstage passes and sellIn date is less than 5 days away`() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 4, 25)
        val gildedRose = GildedRose(arrayOf(backstagePasses))

        gildedRose.updateQuality()

        backstagePasses.quality shouldBe 28
    }

    @Test
    fun `should drop the quality to 0 when item is Backstage passes and sellIn date is today`() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 0, 25)
        val gildedRose = GildedRose(arrayOf(backstagePasses))

        gildedRose.updateQuality()

        backstagePasses.quality shouldBe 0
    }

}