package gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void itemsSellInAndQualityValueDecreasesByOneEachDay() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void whenSellInHasPassedQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item("foo", 0, 4)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void qualityOfItemIsNeverNegative() {
        Item[] items = new Item[]{
                new Item("foo", 1, 0),
                new Item("foo", -1, 1)};  //SellIn has passed, will decrease quality by 2 should stop at 0
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void qualityOfAgedBrieIncreasesWhenOlder() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void qualityNeverIncreasesOver50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurusNeverChanges() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstageIncreasesInQualityDependingOnSellInDaysLeft() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(11, app.items[0].quality);////Quality increases by 1 when there are more than 10 days
        assertEquals(12, app.items[1].quality);//Quality increases by 2 when there are 10 days or less
        assertEquals(13, app.items[2].quality);//Quality increases by 3 when there are 5 days or less
        assertEquals(0, app.items[3].quality); //Quality drops to 0 after the concert
    }

    @Test
    void conjuredItemDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void updateQualitCalledManyTimesShouldUpdateRight() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        app.updateItems();
        app.updateItems();
        app.updateItems();

        assertEquals("+5 Dexterity Vest",app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);

        assertEquals("Aged Brie",app.items[1].name);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(4, app.items[1].quality);

        assertEquals("Elixir of the Mongoose",app.items[2].name);
        assertEquals(1, app.items[2].sellIn);
        assertEquals(3, app.items[2].quality);

//                "Sulfuras, Hand of Ragnaros", 0, 80,
//                "Sulfuras, Hand of Ragnaros", -1, 80,
//                "Backstage passes to a TAFKAL80ETC concert", 11, 24,
//                "Backstage passes to a TAFKAL80ETC concert", 6, 50,
//                "Backstage passes to a TAFKAL80ETC concert", 1, 50,
//                "Conjured Mana Cake", -1, 1
    }


}