package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource(value = {
        "Aged Brie,10,40,9,41",
        "Aged Brie,10,50,9,50",
        "Aged Brie,0,40,-1,42",
        "Aged Brie,-1,40,-2,42"
    })
    void agedBrie(String name, String initialSellIn, String initialQuality, String expectedSellIn, String expectedQuality) {
        Item[] items = new Item[] { new Item(name, Integer.parseInt(initialSellIn), Integer.parseInt(initialQuality)) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(Integer.parseInt(expectedSellIn), app.items[0].sellIn);
        assertEquals(Integer.parseInt(expectedQuality), app.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10,50,9,50", // limited to 50
        "11,40,10,41",
        "10,40,9,42",
        "9,40,8,42",
        "6,40,5,42",
        "5,40,4,43",
        "4,40,3,43",
        "0,40,-1,0",
        "-1,40,-2,0"
    })
    void backstage(String initialSellIn, String initialQuality, String expectedSellIn, String expectedQuality) {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", Integer.parseInt(initialSellIn), Integer.parseInt(initialQuality)) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(Integer.parseInt(expectedSellIn), app.items[0].sellIn);
        assertEquals(Integer.parseInt(expectedQuality), app.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10,40,10,40",
        "10,50,10,50",
        "0,40,0,40",
        "-1,40,-1,40"
    })
    void sulfuras(String initialSellIn, String initialQuality, String expectedSellIn, String expectedQuality) {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", Integer.parseInt(initialSellIn), Integer.parseInt(initialQuality)) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(Integer.parseInt(expectedSellIn), app.items[0].sellIn);
        assertEquals(Integer.parseInt(expectedQuality), app.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10,40,9,39",
        "10,50,9,49",
        "0,40,-1,38",
        "-1,40,-2,38"
    })
    void foo(String initialSellIn, String initialQuality, String expectedSellIn, String expectedQuality) {
        Item[] items = new Item[] { new Item("Foo", Integer.parseInt(initialSellIn), Integer.parseInt(initialQuality)) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Foo", app.items[0].name);
        assertEquals(Integer.parseInt(expectedSellIn), app.items[0].sellIn);
        assertEquals(Integer.parseInt(expectedQuality), app.items[0].quality);
    }
}
